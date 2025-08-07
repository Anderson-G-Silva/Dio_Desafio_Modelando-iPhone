import java.util.Random;
import java.util.Scanner;

public class Phone implements Iphone{
    private static Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean phoneStatus = false;
    boolean callHold = false;
    String action = " ";
    boolean exitLoop = false;
    int soundVolume = 20;
    boolean statusConference = false;
    int messages;

    public boolean isExitLoop() {
        return exitLoop;
    }

    public void setExitLoop(boolean exitLoop) {
        this.exitLoop = exitLoop;
    }

    public boolean isPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(boolean phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public boolean isCallHold() {
        return callHold;
    }

    public void setCallHold(boolean callHold) {
        this.callHold = callHold;
    }

    @Override
    public void checkPhone() throws PhoneExceptions {
        if (this.phoneStatus == true
                && (action.equalsIgnoreCase("call")
                || action.equalsIgnoreCase("answerCall")))
            throw new PhoneExceptions("Existem ligação ativas\n");
        if (this.phoneStatus == false
                && this.callHold == false
                && action.equalsIgnoreCase("endCall"))
            throw new PhoneExceptions("não existem ligações ativas\n");
        if ((this.phoneStatus == true
                || this.callHold == true)
                && action.equalsIgnoreCase("exit"))
            throw new PhoneExceptions("Existem ligações ativas, desligar antes de sair\n");

    }

    @Override
    public void find() {
        action = "find";
        keyboard();
        System.out.println("Digite nome do contato");
        String name = scanner.nextLine();
        System.out.println("Buscando pelo contato "+name+"\n");

    }

    @Override
    public void volume() {
        action = "volume";
        keyboard();
        System.out.println("Ajustar volume >> digite + ou -");
        String volumeAction = scanner.next();
        if (this.soundVolume + 2 > 100 || this.soundVolume - 2 <0)
        {System.out.println("Limite do volume atingido\n");}
        else {  if (volumeAction.equalsIgnoreCase("+")) {this.soundVolume=this.soundVolume+2;}
                else if (volumeAction.equalsIgnoreCase("-")) {this.soundVolume=this.soundVolume-2;}
                else{;}}
        System.out.println("Volume do som "+this.soundVolume+"%\n");

    }


    @Override
    public boolean keyboard() {
        System.out.println("Teclado ativo\n");
        return true;
    }

    public void call(){
        action = "call";
        boolean result = false;
        try{checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            System.out.println("Colocar ligação atual em espera(S ou N?)");
            String option = scanner.next();
            if (option.equalsIgnoreCase("S")||option.equalsIgnoreCase("sim")) {this.callHold = true;}else {return;}
        }
        keyboard();
        System.out.println("Digitar número");
        String number = scanner.next();
        result = random.nextBoolean();
        if(result == true) {Main.musicPlayer.setPause(true);Main.webBrowser.setMute(true);}
        if(this.phoneStatus == true) {this.phoneStatus = true;} else {this.phoneStatus = result;}
        if ( result == false) {System.out.println("Ligação não atendida\n");}
        else {System.out.println("ligação em andamento para "+number+"\n");}
    }

    public void endCall(){
        action = "endCall";
        int option = 0;
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        }
        if (this.phoneStatus == true && this.callHold == false ){this.phoneStatus = false;Main.musicPlayer.setPause(false);Main.webBrowser.setMute(false);}
        if (this.phoneStatus == true && this.callHold == true)
        {System.out.println("Selecione uma opção\n1 - Desligar ligação atual\n2 - desligar ligação em espera\n3 - desligar ambas as ligações\n");
            option = scanner.nextInt();} else {;}
        if (option == 1) {this.phoneStatus = true; this.callHold = false;this.statusConference = false;}
        else if (option == 2){this.callHold = false;this.statusConference = false;}
        else if (option == 3){this.phoneStatus = false; this.callHold = false; this.statusConference = false;Main.musicPlayer.setPause(false);Main.webBrowser.setMute(false);}
        else if (option == 0){;}
        else {System.out.println("opção inválida\n");}
        System.out.println("ligação encerrada\n");

    }

    public void answerCall(){
        action = "answerCall";
        boolean result = false;
        try{checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            System.out.println("Colocar ligação atual em espera(S ou N?)");
            String option = scanner.next();
            if (option.equalsIgnoreCase("S")||option.equalsIgnoreCase("sim")) {this.callHold = true;}else {return;}
        } result = random.nextBoolean();
        if(result == true) {Main.musicPlayer.setPause(true);Main.webBrowser.setMute(true);}
        if(this.phoneStatus == true) {this.phoneStatus = true;} else {this.phoneStatus = result;}
        if ( result == false) {this.messages = this.messages+1;System.out.println("Ligação encaminhada a caixa postal\n");}
        else {System.out.println("Ligação em andamento\n");}

    }

    public void conference(){
        action = "conference";
        if (this.statusConference == true) {System.out.println("Já existe ligação em conferência ativa\n");}
        if (this.phoneStatus == true && this.callHold == true) {System.out.println("Conferência em andamento\n");this.statusConference = true;}
        else if (this.phoneStatus == true && this.callHold == false) {System.out.println("Não é possível realizar conferência, somente uma ligação ativa\n");}
        else {System.out.println("Não existem ligações ativas para conferência\n");}
    }

    public void hold(){
        action = "hold";
        if (this.phoneStatus == true && this.callHold == false){
            this.callHold = true;
            this.phoneStatus = false;
            System.out.println("ligação em espera\n");}
        else if (this.phoneStatus == false && this.callHold == true){
            this.callHold = false;
            this.phoneStatus = true;
            System.out.println("ligação retomada\n");}
        else if (this.phoneStatus == true && this.callHold == true){
            System.out.println("Já existe uma ligação em espera");
        }
        else {System.out.println("Não existe ligação ativa ou em espera\n");
        }
    }

    public void voiceMail(){
        action = "voiceMail";
        String listenMessagens = " ";
        System.out.println("você tem "+this.messages+" mensagens de voz");
        if (this.messages == 0) {System.out.println("Não existem mensagens para ouvir\n");}
        if(this.messages>0)
            {System.out.println("Ouvir mensagens (S ou N)?;");
            listenMessagens = scanner.next();
            if (listenMessagens.equalsIgnoreCase("S") || listenMessagens.equalsIgnoreCase("Sim"))
            {this.messages = this.messages -1;} else{;}}
    }

    public void exit(){
        action = "exit";
        try {
            checkPhone();
        } catch (PhoneExceptions ex){
            this.exitLoop = false;
            System.out.println(ex.getMessage());
            endCall();
            Main.menuPhone();
        } this.exitLoop = true;
    }


}
