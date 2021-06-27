import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class op {

    public static void main(String[] args) throws IOException, InterruptedException {

        double input1 = Double.parseDouble(args[0]);
        double input2 = Double.parseDouble(args[1]);
        int input3 = Integer.parseInt(args[2]);

        double n1 = input1;
        double n2 = input2;
        int o = input3;

        Random random = new Random();
        int aleatorio = random.nextInt(5000);
        double r = operacoes(n1, n2, o);

        System.out.println("Resultado: " + r);

        System.out.println("Iniciando coleta de dados para criar relatorio...");
        FileWriter arquivo;

        try {
            arquivo = new FileWriter(new File("DirShell01/registro" + aleatorio + ".txt"));
            arquivo.write("Variaveis: " + n1 + ", " + n2 + "\n");
            switch (o) {
                case 1:
                    arquivo.write("Operação: Adição \n");
                    break;
                case 2:
                    arquivo.write("Operação: Subtração \n");
                    break;
                case 3:
                    arquivo.write("Operação: Multiplicação \n");
                    break;
                case 4:
                    arquivo.write("Operação: Divisão \n");
                    break;
            }
            arquivo.write("Resultado: " + r);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Coleta e criação de registro bem sucedidos!");
        
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Iniciando transferencia de registro para o diretorio DirShell02...");
        File arq = new File("DirShell01/registro" + aleatorio + ".txt");
 
        if (!arq.exists()) {
            System.out.println("Arquivo não encontrado");
        } else {
 
            // Diretorio de destino
            File Destino = new File("DirShell02");
 
            // Move o arquivo para o novo diretorio
            boolean s = arq.renameTo(new File(Destino, arq.getName()));
            if (s) {
                System.out.println("Arquivo movido para '" + Destino.getAbsolutePath() + "' com sucesso!");
            } else {
                System.out.println("Erro ao mover arquivo '" + arq.getAbsolutePath() + "' para '"
                        + Destino.getAbsolutePath() + "'");
            }
        }

    }

    public static double operacoes(double n1, double n2, int o) {
        double resultado = 0;

        switch (o) {
            case 1:
                resultado = n1 + n2;
                break;
            case 2:
                resultado = n1 - n2;
                break;
            case 3:
                resultado = n1 * n2;
                break;
            case 4:
                resultado = n1 / n2;
                break;
            default:
                System.out.println("ERRO: Operação invalida!");
                break;
        }

        return resultado;
    }
}
