package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;

public class Util {
    private Fornecedor[] fornecedores = new Fornecedor[4];
    private Produto[] produtos = new Produto[4];
    private int indexProduto = 0;
    private int indexFornecedor = 0;


    public void menuOptions(){
        int op = Integer.parseInt(showInputDialog("1. Cadastrar produto\n2. Pesquisar produto por nome\n3. Pesquisar fornecedor por CNPJ\n4. Finalizar"));
        while(true){

            switch (op){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisarFornecedor();
                    break;
                case 4:
                    return;
                default:
                    showMessageDialog(null,"opção invalida");

            }


        }

    }

    private void cadastrarProduto() {
        pesquisarFornecedor();
    }

    private void pesquisarProduto() {
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
