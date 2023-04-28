import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Colaborador> colaboradores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o nome do colaborador " + (i+1) + ": ");
            String nome = scanner.nextLine();

            System.out.println("Digite o CPF do colaborador " + (i+1) + ": ");
            String cpf = scanner.nextLine();

            System.out.println("Digite o telefone do colaborador " + (i+1) + ": ");
            String telefone = scanner.nextLine();

            System.out.println("Digite a data de nascimento do colaborador " + (i+1) + " (dd/MM/yyyy): ");
            String dataNascimentoStr = scanner.nextLine();

            System.out.println("Digite a data de agendamento do colaborador " + (i+1) + " (dd/MM/yyyy): ");
            String dataAgendamentoStr = scanner.nextLine();

            System.out.println("Digite o período do colaborador " + (i+1) + " (manhã, tarde ou noite): ");
            String periodo = scanner.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = null;
            Date dataAgendamento = null;
            try {
                dataNascimento = sdf.parse(dataNascimentoStr);
                dataAgendamento = sdf.parse(dataAgendamentoStr);
            } catch (ParseException e) {
                System.out.println("Data inválida! Tente novamente.");
                i--;
                continue;
            }

            Colaborador colaborador = new Colaborador(nome, cpf, telefone, dataNascimento, dataAgendamento, periodo);
            colaboradores.add(colaborador);
        }

        for (Colaborador colaborador : colaboradores) {
            System.out.println(colaborador.getNome() + ", " + colaborador.getCpf() + ", " + colaborador.getTelefone() + ", " + colaborador.getDataNascimento() + ", " + colaborador.getDataAgendamento() + ", " + colaborador.getPeriodo());
        }

        scanner.close();
    }
}
