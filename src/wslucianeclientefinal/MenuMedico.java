package wslucianeclientefinal;

import VO.Medico;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MenuMedico {
    
    private static final int CADASTRAR_MEDICO = 1;
    private static final int EXCLUIR_MEDICO = 2;
    private static final int ATUALIZAR_MEDICO = 3;
    private static final int EXIBIR_MEDICO_POR_CRM = 4;
    private static final int SAIR = 5;

    public void chamaMenuMedico() {
        
        int opcao = -1;
        
        while(opcao != SAIR){
            
            try{
                String valorDigitado = (JOptionPane.showInputDialog(chamaOpcoesMenuMedico()));
               if(valorDigitado != null){
                 opcao = Integer.parseInt(valorDigitado); 
               }else{
                   break;
               }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro entre 1 e 5.");
            }
            switch (opcao){
                case CADASTRAR_MEDICO:
                    this.cadastrarMedico();
                    break;
                case EXCLUIR_MEDICO:
                    this.excluirMedico();
                    break;
                case ATUALIZAR_MEDICO:
                    this.atualizaMedico();
                    break;
                 case EXIBIR_MEDICO_POR_CRM:
                      this.exibirMedicoCRM();
                     break;
                case SAIR:
                    int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
                    if(resposta == 0){
                        JOptionPane.showMessageDialog(null, "Você foi desconectado do Menu Médico!!");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite a opção");
            }
        }
    }

    private String chamaOpcoesMenuMedico() {
        String mensagem = "Menu Médico.";
        mensagem += "\n1 - Cadastrar Médico.";
        mensagem += "\n2 - Excluir Médico.";
        mensagem += "\n3 - Atualizar Médico.";   
        mensagem += "\n4 - Exibir médico por CRM.";
        mensagem += "\n5 - Sair.";
                       
        return mensagem;
    }
  
    private void cadastrarMedico() {
        
	Medico medico = new Medico();			
	
        medico.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
	if (MenuMedico.existeRegistroPorCpf(medico.getCpf())){
	JOptionPane.showMessageDialog(null, "Médico4"
                + " já cadastrado! Tente novamente.");
	}else{
	   
        medico.setMedNome(JOptionPane.showInputDialog(null, "Digite o nome do médico."));
        medico.setCrm(JOptionPane.showInputDialog(null, "Digite o CRM do médico."));
        medico.setCelMensagem(JOptionPane.showInputDialog(null, "Digite o Celular para mensagem do médico."));
        medico.setCel(JOptionPane.showInputDialog(null, "Digite o Celular do médico."));
        medico.setEmail(JOptionPane.showInputDialog(null, "Digite o e-mail do médico."));
        medico.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do médico para cadastrar."));
        medico.setCnpj(JOptionPane.showInputDialog(null, "Digite o CNPJ do médico para cadastrar."));
        medico.setLogradouro(JOptionPane.showInputDialog(null, "Digite o Logradouro da residência."));
        medico.setNumLog(JOptionPane.showInputDialog(null, "Digite o número da residência."));
        medico.setComplemento(JOptionPane.showInputDialog(null, "Digite o complemento do endereço do médico."));
        medico.setBairro(JOptionPane.showInputDialog(null, "Digite o Bairro."));
        medico.setCidade(JOptionPane.showInputDialog(null, "Digite o nome do cidade."));
        medico.setUf(JOptionPane.showInputDialog(null, "Digite o Estado."));
        medico.setCep ( JOptionPane.showInputDialog(null, "Digite CEP da residência."));
        
        MenuMedico.inserirMedico(medico.getMedNome(), medico.getCrm(), medico.getCelMensagem(),medico.getCel(), medico.getEmail(), medico.getCpf(), medico.getCnpj(), medico.getLogradouro(), medico.getNumLog(), medico.getComplemento(), medico.getBairro(), medico.getCidade(), medico.getUf(), medico.getCep());
        JOptionPane.showMessageDialog(null,"Médico cadastrado com sucesso!");
        }  
          
}
    
    private void excluirMedico() {
      Medico medico = new Medico();
      medico.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do médico para excluir"));
      MenuMedico.deleteMedico(medico.getCpf());
          JOptionPane.showMessageDialog(null,"Medico deleteado com sucesso!");

      }
        
     private void atualizaMedico() {
        Medico medico = new Medico();
                  
      medico.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do médico para atualizar."));
      if(MenuMedico.existeRegistroPorCpf((medico.getCpf()))){
       
           medico.setMedNome(JOptionPane.showInputDialog(null, "Digite o nome do medico."));
           medico.setCrm(JOptionPane.showInputDialog(null, "Digite o CRM do médico."));
           medico.setCelMensagem(JOptionPane.showInputDialog(null, "Digite o Celular para mensagem do médico."));
           medico.setCel(JOptionPane.showInputDialog(null, "Digite o Celular do médico."));
           medico.setEmail(JOptionPane.showInputDialog(null, "Digite o e-mail do médico."));
           medico.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do médico para cadastrar."));
           medico.setCnpj(JOptionPane.showInputDialog(null, "Digite o CNPJ do médico para cadastrar."));
           medico.setLogradouro(JOptionPane.showInputDialog(null, "Digite o Logradouro da residência."));
           medico.setNumLog(JOptionPane.showInputDialog(null, "Digite o número da residência."));
           medico.setComplemento(JOptionPane.showInputDialog(null, "Digite o complemento do endereço do médico."));
           medico.setBairro(JOptionPane.showInputDialog(null, "Digite o Bairro."));
           medico.setCidade(JOptionPane.showInputDialog(null, "Digite o nome do cidade."));
           medico.setUf(JOptionPane.showInputDialog(null, "Digite o Estado."));

           MenuMedico.atualizarMedico(medico.getMedNome(), medico.getCrm(), medico.getCelMensagem(),medico.getCel(), medico.getEmail(), medico.getCpf(), medico.getCnpj(), medico.getLogradouro(), medico.getNumLog(), medico.getComplemento(), medico.getBairro(), medico.getCidade(), medico.getUf(), medico.getCep(), medico.getCpf());
           JOptionPane.showMessageDialog(null, "Médico atualizado com sucesso!");
           }else{
           JOptionPane.showMessageDialog(null, "Não foi possível atualizar o Médico!");
                 
           }
        }
     
    
      private void exibirMedicoCRM(){
        Medico medicoConsultado = new Medico();       
        medicoConsultado.setCrm(JOptionPane.showInputDialog(null, "Digite o CRM do Médico para consultar."));

        if(medicoConsultado != null) {
            MenuMedico.consultarMedicoPorCRM(medicoConsultado.getCrm());
            JOptionPane.showMessageDialog(null, medicoConsultado);
            }else {
            JOptionPane.showMessageDialog(null,"Médico não encontrado. Tente novamente!");   
             }    
            
        }

    private static boolean atualizarMedico(java.lang.String medNome, java.lang.String crm, java.lang.String celMen, java.lang.String cel, java.lang.String email, java.lang.String cpf, java.lang.String cnpj, java.lang.String logradouro, java.lang.String numLog, java.lang.String complemento, java.lang.String bairro, java.lang.String cidade, java.lang.String uf, java.lang.String cep, java.lang.String cpfAtual) {
        dao.MedicoDAO_Service service = new dao.MedicoDAO_Service();
        dao.MedicoDAO port = service.getMedicoDAOPort();
        return port.atualizarMedico(medNome, crm, celMen, cel, email, cpf, cnpj, logradouro, numLog, complemento, bairro, cidade, uf, cep, cpfAtual);
    }

    private static java.util.List<dao.Medico> consultarMedicoPorCRM(java.lang.String crm) {
        dao.MedicoDAO_Service service = new dao.MedicoDAO_Service();
        dao.MedicoDAO port = service.getMedicoDAOPort();
        return port.consultarMedicoPorCRM(crm);
    }

    private static boolean deleteMedico(java.lang.String cpf) {
        dao.MedicoDAO_Service service = new dao.MedicoDAO_Service();
        dao.MedicoDAO port = service.getMedicoDAOPort();
        return port.deleteMedico(cpf);
    }

    private static boolean existeRegistroPorCpf(java.lang.String cpf) {
        dao.MedicoDAO_Service service = new dao.MedicoDAO_Service();
        dao.MedicoDAO port = service.getMedicoDAOPort();
        return port.existeRegistroPorCpf(cpf);
    }

    private static int inserirMedico(java.lang.String medNome, java.lang.String crm, java.lang.String celMen, java.lang.String cel, java.lang.String email, java.lang.String cpf, java.lang.String cnpj, java.lang.String logradouro, java.lang.String numLog, java.lang.String complemento, java.lang.String bairro, java.lang.String cidade, java.lang.String uf, java.lang.String cep) {
        dao.MedicoDAO_Service service = new dao.MedicoDAO_Service();
        dao.MedicoDAO port = service.getMedicoDAOPort();
        return port.inserirMedico(medNome, crm, celMen, cel, email, cpf, cnpj, logradouro, numLog, complemento, bairro, cidade, uf, cep);
    }

}
    

    


       
