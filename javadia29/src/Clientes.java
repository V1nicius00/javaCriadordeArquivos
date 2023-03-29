import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Clientes {

    public static void main(String[] args) throws Exception {
        
        DecimalFormat df = new DecimalFormat("#.00");

        double valorInicial = 0, valorFinal = 0;
        int control = 0;
        
        Scanner scan = new Scanner(System.in);

        String arquivoOrigem = "C:\\desenvolvimentoSoftware_ADS\\Manha\\Java29\\javadia29\\src\\clientes.csv";
        File arquivo = new File(arquivoOrigem);
        Scanner leitor = new Scanner(arquivo);

        
        System.out.println("Digite um valor inicial: ");
        valorInicial = scan.nextDouble();
        
        System.out.println("Digite um valor final: ");
        valorFinal = scan.nextDouble();
        
        String arquivoNovo = "clientes-" + valorInicial + "a" + valorFinal + ".txt";
        
        FileWriter newArchive = new FileWriter("C:\\desenvolvimentoSoftware_ADS\\Manha\\Java29\\javadia29\\src\\" + arquivoNovo);

        PrintWriter escritor = new PrintWriter(newArchive);
        
        Formatter gravador = new Formatter(newArchive);
        
        String linha1 = leitor.nextLine();
        String[] vetor1 = linha1.split(";");

        while(leitor.hasNextLine()){

            String linha = leitor.nextLine();
            String[] vetor = linha.split(";");

            double credito = Double.parseDouble(vetor[3].replace(",",".").replace(",","."));

            if(credito >= valorInicial && credito <= valorFinal){
                gravador.format("\nCPF: " + vetor[0] + "\n");
                gravador.format("Nome: " + vetor[1] + "\n");
                gravador.format("Código: " + vetor[2] + "\n");
                gravador.format("Crédito: " + df.format(credito) + "\n");
                control++;
            }

            
        }
        
        if(control == 0) {
        	System.out.println("Não foram encontrados clientes na faixa de crédito informada.");
        	gravador.format("Não foram encontrados clientes na faixa de crédito informada.");
        }

        scan.close();
        gravador.close();
        leitor.close();
        escritor.close();
        	
    }
}
