package com.comprasvendas.view;

import com.comprasvendas.dao.ClientesDAO;
import com.comprasvendas.dao.FornecedoresDAO;
import com.comprasvendas.dao.MovimentacaoNotaDAO;
import com.comprasvendas.dao.ProdutosDAO;
import com.comprasvendas.model.Clientes;
import com.comprasvendas.model.Fornecedores;
import com.comprasvendas.model.ItemNota;
import com.comprasvendas.model.MovimentacaoNota;
import com.comprasvendas.model.Produtos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MovimentacaoNotaPanel extends JPanel {

    private MovimentacaoNotaDAO movimentacaoNotaDAO;
    private ClienteDAO clienteDAO;
    private FornecedorDAO fornecedorDAO;
    private ProdutoDAO produtoDAO;

    private JComboBox<String> tipoMovimentacaoComboBox;
    private JComboBox<Object> pessoaComboBox; // Cliente ou Fornecedor
    private JComboBox<Produto> produtoComboBox;
    private JTextField quantidadeProdutoField;
    private JTextField dataMovimentacaoField;

    private DefaultTableModel itensTableModel;
    private JTable itensTable;
    private List<ItemNota> itensTemporarios;

    private JButton adicionarItemButton;
    private JButton salvarNotaButton;
    private JButton limparCamposButton;
    private JButton listarNotasButton;

    private DefaultTableModel notasTableModel;
    private JTable notasTable;

    public MovimentacaoNotaPanel(MovimentacaoNotaDAO movimentacaoNotaDAO, ClienteDAO clienteDAO, FornecedorDAO fornecedorDAO, ProdutoDAO produtoDAO) {
        this.movimentacaoNotaDAO = movimentacaoNotaDAO;
        this.clienteDAO = clienteDAO;
        this.fornecedorDAO = fornecedorDAO;
        this.produtoDAO = produtoDAO;
        this.itensTemporarios = new ArrayList<>();

        setLayout(new BorderLayout());

        // Painel de Formulário
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tipo de Movimentação
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Tipo de Movimentação:"), gbc);
        gbc.gridx = 1;
        tipoMovimentacaoComboBox = new JComboBox<>(new String[]{"ENTRADA", "SAIDA"});
        tipoMovimentacaoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarPessoaComboBox();
            }
        });
        formPanel.add(tipoMovimentacaoComboBox, gbc);

        // Pessoa (Cliente/Fornecedor)
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Pessoa:"), gbc);
        gbc.gridx = 1;
        pessoaComboBox = new JComboBox<>();
        formPanel.add(pessoaComboBox, gbc);

        // Data da Movimentação
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Data (AAAA-MM-DD):"), gbc);
        gbc.gridx = 1;
        dataMovimentacaoField = new JTextField(LocalDate.now().toString());
        formPanel.add(dataMovimentacaoField, gbc);

        // Produto
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Produto:"), gbc);
        gbc.gridx = 1;
        produtoComboBox = new JComboBox<>();
        formPanel.add(produtoComboBox, gbc);

        // Quantidade do Produto
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1;
        quantidadeProdutoField = new JTextField(10);
        formPanel.add(quantidadeProdutoField, gbc);

        // Botão Adicionar Item
        gbc.gridx = 1;
        gbc.gridy = 5;
        adicionarItemButton = new JButton("Adicionar Item");
        adicionarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });
        formPanel.add(adicionarItemButton, gbc);

        // Tabela de Itens Temporários
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        itensTableModel = new DefaultTableModel(new Object[]{"Produto", "Quantidade", "Preço Unitário"}, 0);
        itensTable = new JTable(itensTableModel);
        formPanel.add(new JScrollPane(itensTable), gbc);

        // Painel de Botões de Ação da Nota
        JPanel actionButtonsPanel = new JPanel(new FlowLayout());
        salvarNotaButton = new JButton("Salvar Nota");
        salvarNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarNota();
            }
        });
        actionButtonsPanel.add(salvarNotaButton);

        limparCamposButton = new JButton("Limpar Campos");
        limparCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        actionButtonsPanel.add(limparCamposButton);

        listarNotasButton = new JButton("Listar Notas");
        listarNotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarNotas();
            }
        });
        actionButtonsPanel.add(listarNotasButton);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(actionButtonsPanel, gbc);

        add(formPanel, BorderLayout.NORTH);

        // Painel de Listagem de Notas
        JPanel listPanel = new JPanel(new BorderLayout());
        notasTableModel = new DefaultTableModel(new Object[]{"Código", "Tipo", "Pessoa", "Data", "Itens"}, 0);
        notasTable = new JTable(notasTableModel);
        listPanel.add(new JScrollPane(notasTable), BorderLayout.CENTER);

        add(listPanel, BorderLayout.CENTER);

        // Inicializar ComboBoxes
        preencherProdutoComboBox();
        atualizarPessoaComboBox();
        listarNotas();
    }

    public void preencherProdutoComboBox() {
        produtoComboBox.removeAllItems();
        for (Produto p : produtoDAO.findAll()) {
            produtoComboBox.addItem(p);
        }
    }

    public void atualizarPessoaComboBox() {
        pessoaComboBox.removeAllItems();
        String tipo = (String) tipoMovimentacaoComboBox.getSelectedItem();
        if ("ENTRADA".equals(tipo)) {
            for (Fornecedor f : fornecedorDAO.findAll()) {
                pessoaComboBox.addItem(f);
            }
        } else if ("SAIDA".equals(tipo)) {
            for (Cliente c : clienteDAO.findAll()) {
                pessoaComboBox.addItem(c);
            }
        }
    }

    private void adicionarItem() {
        Produto produtoSelecionado = (Produto) produtoComboBox.getSelectedItem();
        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeProdutoField.getText());
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser um número positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar estoque para notas de SAIDA
        String tipo = (String) tipoMovimentacaoComboBox.getSelectedItem();
        if ("SAIDA".equals(tipo)) {
            if (produtoSelecionado.getQuantidadeEstoque() < quantidade) {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente para o produto " + produtoSelecionado.getNome() + ". Disponível: " + produtoSelecionado.getQuantidadeEstoque(), "Erro de Estoque", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Adicionar item à lista temporária
        ItemNota item = new ItemNota(0, 0, produtoSelecionado, quantidade, produtoSelecionado.getPrecoVenda());
        itensTemporarios.add(item);
        itensTableModel.addRow(new Object[]{produtoSelecionado.getNome(), quantidade, produtoSelecionado.getPrecoVenda()});

        quantidadeProdutoField.setText("");
    }

    private void salvarNota() {
        String tipo = (String) tipoMovimentacaoComboBox.getSelectedItem();
        Object pessoaSelecionada = pessoaComboBox.getSelectedItem();
        String dataStr = dataMovimentacaoField.getText();

        if (tipo == null || pessoaSelecionada == null || dataStr.isEmpty() || itensTemporarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos e adicione pelo menos um item.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate dataMovimentacao;
        try {
            dataMovimentacao = LocalDate.parse(dataStr);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use AAAA-MM-DD.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int pessoaCodigo = 0;
        String pessoaNome = "";

        if ("ENTRADA".equals(tipo) && pessoaSelecionada instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) pessoaSelecionada;
            pessoaCodigo = fornecedor.getCodigo();
            pessoaNome = fornecedor.getNomeFantasia();
        } else if ("SAIDA".equals(tipo) && pessoaSelecionada instanceof Cliente) {
            Cliente cliente = (Cliente) pessoaSelecionada;
            pessoaCodigo = cliente.getCodigo();
            pessoaNome = cliente.getNome();
        } else {
            JOptionPane.showMessageDialog(this, "Seleção de pessoa inválida para o tipo de movimentação.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        MovimentacaoNota novaNota = new MovimentacaoNota(0, tipo, pessoaCodigo, pessoaNome, dataMovimentacao);
        for (ItemNota item : itensTemporarios) {
            novaNota.addItens(item);
        }

        movimentacaoNotaDAO.save(novaNota);

        // Atualizar estoque dos produtos
        for (ItemNota item : itensTemporarios) {
            Produtos produtos = item.getProdutos();
            if ("ENTRADA".equals(tipo)) {
                produtos.setQuantidadeEstoque(produtos.getQuantidadeEstoque() + item.getQuantidade());
            } else if ("SAIDA".equals(tipo)) {
                produto.setQuantidadeEstoque(produtos.getQuantidadeEstoque() - item.getQuantidade());
            }
            produtoDAO.update(produto);
        }

        JOptionPane.showMessageDialog(this, "Nota salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        listarNotas();
    }

    private void limparCampos() {
        tipoMovimentacaoComboBox.setSelectedIndex(0);
        pessoaComboBox.removeAllItems();
        dataMovimentacaoField.setText(LocalDate.now().toString());
        produtoComboBox.setSelectedIndex(0);
        quantidadeProdutoField.setText("");
        itensTemporarios.clear();
        itensTableModel.setRowCount(0);
        atualizarPessoaComboBox();
    }

    public void listarNotas() {
        notasTableModel.setRowCount(0);
        for (MovimentacaoNota nota : movimentacaoNotaDAO.findAll()) {
            StringBuilder itensStr = new StringBuilder();
            for (ItemNota item : nota.getItens()) {
                itensStr.append(item.getProdutos().getNome()).append(" (").append(item.getQuantidade()).append(") ");
            }
            notasTableModel.addRow(new Object[]{
                nota.getCodigo(),
                nota.getTipoMovimentacao(),
                nota.getPessoaNome(),
                nota.getDataMovimentacao(),
                itensStr.toString()
            });
        }
    }
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
