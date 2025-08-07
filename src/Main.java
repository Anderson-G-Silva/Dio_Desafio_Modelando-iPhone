import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static Phone phone = new Phone();
    public static MusicPlayer musicPlayer = new MusicPlayer();
    public static WebBrowser webBrowser = new WebBrowser();
    public static Main main = new Main();
    boolean wifi = true;
    boolean mobileData = true;

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isMobileData() {
        return mobileData;
    }

    public void setMobileData(boolean mobileData) {
        this.mobileData = mobileData;
    }

    // Main
    public static void main (String[] args){
        int option=0;
        while (option !=6) {
            System.out.println(">>Bem vindo ao iPhone 2007<<\n Selecione a opção desejada\n");
            System.out.println("1 - Telefone");
            System.out.println("2 - Music Player");
            System.out.println("3 - Navegador Internet");
            System.out.println("4 - Wifi (ON/OFF)");
            System.out.println("5 - Dados móveis (ON/OFF) ");
            System.out.println("6 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> menuPhone();
                case 2 -> menuMusicPlayer();
                case 3 -> menuWebBrowser();
                case 4 -> wifi() ;
                case 5 -> mobileData();
                case 6 -> {System.out.println("Obrigado por utilizar o iPhone7\nDesligando");break;}
                default -> System.out.println("Opção inválida");
            }
        }

    }

    // Menu telefone. Seleciona as funcionalidades do aplicativo.
    public static void menuPhone(){
        int option=0;
        while (option !=9) {
            System.out.println(">>    Menu telefone    <<\nSelecione a opção desejada\n");
            System.out.println("1 - Ligar");
            System.out.println("2 - Atender");
            System.out.println("3 - Encerrar ligação");
            System.out.println("4 - Correio de voz");
            System.out.println("5 - Pesquisar contatos");
            System.out.println("6 - Colocar ligação em espera / retomar ligação");
            System.out.println("7 - Colocar ligações em conferência");
            System.out.println("8 - Ajustar volume (+ / -)");
            System.out.println("9 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> phone.call();
                case 2 -> phone.answerCall();
                case 3 -> phone.endCall();
                case 4 -> phone.voiceMail();
                case 5 -> phone.find();
                case 6 -> phone.hold();
                case 7 -> phone.conference();
                case 8 -> phone.volume();
                case 9 -> {
                    phone.exit();
                    break;
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }
    // Menu Music Player. Seleciona as funcionalidades do aplicativo.
    public static void menuMusicPlayer(){
        int option=0;
        while (option !=9) {
            System.out.println(">>   Menu Music Player   <<\nSelecione a opção desejada\n");
            System.out.println("1 - Tocar/Parar");
            System.out.println("2 - Pausar/Retomar");
            System.out.println("3 - Selecionar música");
            System.out.println("4 - Avançar música");
            System.out.println("5 - Voltar música");
            System.out.println("6 - Repetir música");
            System.out.println("7 - Ajustar volume (+ / -)");
            System.out.println("8 - Mute (ON/OFF)");
            System.out.println("9 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> musicPlayer.playStop();
                case 2 -> musicPlayer.pause();
                case 3 -> musicPlayer.find();
                case 4 -> musicPlayer.moveFoward();
                case 5 -> musicPlayer.moveBack();
                case 6 -> musicPlayer.repeat();
                case 7 -> musicPlayer.volume();
                case 8 -> musicPlayer.mute();
                case 9 -> {break;}
                default -> System.out.println("Opção inválida");
            }
        }
    }
    // Menu Navegador. Seleciona as funcionalidades do aplicativo.
    public static void menuWebBrowser(){
        int option=0;
        while (option !=8) {
            System.out.println(">>    Menu Navegador    <<\nSelecione a opção desejada\n");
            System.out.println("1 - Exibir página");
            System.out.println("2 - Adicionar nova página");
            System.out.println("3 - Atualizar página");
            System.out.println("4 - Procurar página");
            System.out.println("5 - Google maps");
            System.out.println("6 - E-mail");
            System.out.println("7 - Ajustar volume (+ / -)");
            System.out.println("8 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> webBrowser.showPage();
                case 2 -> webBrowser.addPage();
                case 3 -> webBrowser.updatePage();
                case 4 -> webBrowser.find();
                case 5 -> webBrowser.maps();
                case 6 -> webBrowser.email();
                case 7 -> webBrowser.volume();
                case 8 -> {break;}
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private static void wifi(){
        if (main.isWifi() == true) {main.wifi = false; System.out.println("Wifi desligado");}
        else {main.wifi = true; System.out.println("Wifi ligado");}
    }

    private static void mobileData(){
        if (main.isMobileData() == true) {main.mobileData = false; System.out.println("Dados móveis desligado");}
        else {main.mobileData = true; System.out.println("Dados móveis ligado");}
    }
}


