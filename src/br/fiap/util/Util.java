package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;

public class Util {
    private Fornecedor[] fornecedores = new Fornecedor[4];
    private Produto[] produtos = new Produto[4];
    private int indexProduto = 0;
    private int indexFornecedor = 0;


    public void menuOptions(){
        int op ;
        while(true){
            op = Integer.parseInt(showInputDialog("1. Cadastrar produto\n2. Pesquisar produto por nome\n3. Pesquisar fornecedor por CNPJ\n4. Finalizar"));

            switch (op){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    return;
                default:
                    showMessageDialog(null,"opção invalida");

            }


        }

    }

    private void pesquisar() {
        Fornecedor fornecedor = pesquisarFornecedor();
        String msg = "";
        if (fornecedor != null) {
            msg += "Fornecedor: " + fornecedor.getNome() + "\n";
            msg += "CNPJ: " + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, msg);
        }

    }

    private void cadastrarProduto() {
        Fornecedor f = pesquisarFornecedor();
        if(f == null){
            f = cadastrarFornecedor();
        }

        String nome = showInputDialog("Nome do produto: ");
        double valor = Double.parseDouble(showInputDialog("Valor unitário do produto: "));
        int qntd = Integer.parseInt(showInputDialog("Quantidade de produtos em estoque"));
        produtos[indexProduto++] = new Produto(nome, valor, qntd, f);
        return;

    }

    private Fornecedor cadastrarFornecedor() {
        String nome = showInputDialog("Digite o nome do fornecedor: ");
        long cnpj = Long.parseLong(showInputDialog("Digite o cnpj do fornecedor: "));
        Fornecedor f = new Fornecedor(nome, cnpj);
        fornecedores[indexFornecedor] = f;
        indexFornecedor++;
        return f;




    }

    private void pesquisarProduto() {
        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "Produto não cadastrado";
        String nome = showInputDialog("Nome do produto");
        for(int i = 0; i < indexProduto; i++){
            if(produtos[i].getNome().equalsIgnoreCase(nome)) {
                msg = "";
                msg += "Nome do produto: " + nome + "\n";
                msg += "Valor unitário do produto: $" + df.format(produtos[i].getValorUnitario()) + "\n";
                msg += "Fornecedor: " + produtos[i].getFornecedor().getNome() + "\n";
            }
        }
        showMessageDialog(null, msg);
    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = Long.parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < indexFornecedor; i++) {
            if (cnpj == fornecedores[i].getCnpj()){
                return fornecedores[i];
            }
        }
        showMessageDialog(null, "CNPJ " + cnpj + " não cadastrado");
        return null;

    }



}
