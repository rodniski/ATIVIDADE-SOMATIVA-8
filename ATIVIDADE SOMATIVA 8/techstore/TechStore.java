package techstore;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class TechStore {
    private ArrayList<Tech> tech;

    public TechStore() {
		this.tech = new ArrayList<Tech>();
	}

    public String[] leValores(String[] dadosIn) {
        String[] dadosOut = new String[dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog("Entre com " + dadosIn[i] + ": ");

        return dadosOut;
    }

    public Celular leCelular() {

        String[] valores = new String[3];
        String[] nomeVal = { "Marca","Modelo", "Camera", "Preco" };
        valores = leValores(nomeVal);

        int camera = this.retornaInteiro(valores[2]);
        int preco = this.retornaInteiro(valores[3]);

        Celular celular = new Celular(valores[0], valores[1], camera, preco);
        return celular;
    }

    public Notebook leNotebook() {

        String[] valores = new String[3];
        String[] nomeVal = { "Marca", "Modelo", "Processador", "Preco" };
        valores = leValores(nomeVal);

        int preco = this.retornaInteiro(valores[3]);

        Notebook notebook = new Notebook(valores[0], valores[1], valores[2], preco);
        return notebook;
    }

    public Relogio leRelogio() {

        String[] valores = new String[3];
        String[] nomeVal = { "Marca", "Modelo", "Pulseira", "Preco" };
        valores = leValores(nomeVal);

        int preco = this.retornaInteiro(valores[3]);

        Relogio relogio = new Relogio(valores[0], valores[1], valores[2], preco);
        return relogio;
    }

    private boolean intValido(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int retornaInteiro(String entrada) {

        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null,
                    "Valor de " + entrada + " incorreto!\n\nDigite um numero inteiro como opção.");
        }
        return Integer.parseInt(entrada);
    }

    public void salvaProdutos(ArrayList<Tech> tech) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("c:\\temp\\Store.dados"));
            for (int i = 0; i < tech.size(); i++)
                outputStream.writeObject(tech.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Impossivel criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Tech> recuperaProdutos() {
        ArrayList<Tech> ProdutoTemp = new ArrayList<Tech>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream("C:\\Windows\\Temp\\techstore.dados"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Tech) {
                    ProdutoTemp.add((Tech) obj);
                }
            }
        } catch (EOFException ex) {
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "===================================           \n" +
                            "       O arquivo com produtos nao existe!\n" +
                            "===================================\n");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        return ProdutoTemp;
    }

    public void menuTechStore() {

        String menu = "";
        String entrada;
        int opc1, opc2;

        do {
            menu = "Controle de Produtos da Loja - TechStore\n" +
                    "Opcoes:\n" +
                    "1. Entrar Produtos\n" +
                    "2. Exibir Produtos\n" +
                    "3. Limpar Produtos\n" +
                    "4. Gravar Produtos\n" +
                    "5. Recuperar Produtos\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog(menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:
                    menu = "Entrada de Produtos\n" +
                            "Opcoes:\n" +
                            "1. Celular\n" +
                            "2. Notebook\n" +
                            "3. Relogio\n";

                    entrada = JOptionPane.showInputDialog(menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2) {
                        case 1:
                            tech.add((Tech) leCelular());
                            break;
                        case 2:
                            tech.add((Tech) leNotebook());
                            break;
                        case 3:
                            tech.add((Tech) leRelogio());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Produto para entrada NAO escolhido!");
                    }

                    break;
                case 2:
                    if (tech.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Entre com produtos primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i = 0; i < tech.size(); i++) {
                        dados += tech.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null, dados);
                    break;
                case 3:
                    if (tech.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Entre com produtos primeiramente");
                        break;
                    }
                    tech.clear();
                    JOptionPane.showMessageDialog(null, "Dados LIMPOS com sucesso!");
                    break;
                case 4:
                    if (tech.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Entre com produtos primeiramente");
                        break;
                    }
                    salvaProdutos(tech);
                    JOptionPane.showMessageDialog(null, "Dados SALVOS com sucesso!");
                    break;
                case 5:
                    tech = recuperaProdutos();
                    if (tech.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Encerrando... TechStore - Volte Sempre!");
                    break;
            }
        } while (opc1 != 9);
    }

    public static void main(String[] args) {

        TechStore pet = new TechStore();
        pet.menuTechStore();

    }
}
