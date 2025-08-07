import java.util.Scanner;

public class WebBrowser implements Iphone{

    private static Scanner scanner = new Scanner(System.in);

    boolean mute = false;
    String action;
    int soundVolume = 20;

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    @Override
    public void checkPhone() throws PhoneExceptions {
        if (Main.main.isWifi() ==  false && Main.main.isMobileData() == false )
            throw new PhoneExceptions("Sem internet\n");
    }

    @Override
    public void find() {
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        }
        keyboard();
        System.out.println("pesquisa >> digite");
        String search = scanner.nextLine();
        System.out.println("Buscando pela pesquisa >> "+search+"\n");
    }

    @Override
    public void volume() {
        keyboard();
        System.out.println("Ajustar volume >> digite + ou -");
        String volumeAction = scanner.next();
        if (soundVolume + 2 > 100 || soundVolume - 2 <0)
        {System.out.println("Limite do volume atingido\n");}
        else {  if (volumeAction.equalsIgnoreCase("+")) {soundVolume=soundVolume+2;}
        else if (volumeAction.equalsIgnoreCase("-")) {soundVolume=soundVolume-2;}
        else{;}}
        System.out.println("Volume do som "+soundVolume+"%\n");
    }

    @Override
    public boolean keyboard() {
        System.out.println("Teclado ativo\n");
        return true;
    }

    public void showPage(){
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Página exibida com sucesso\n");
    }

    public void addPage(){
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Página adiciona com sucesso\n");
    }

    public void updatePage(){
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Página atualizada com sucesso\n");
    }

    public void maps(){
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Maps -Ativo \n");
        find();
        System.out.println("Maps - Buscando a localização\n");
    }

    public void email(){
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        } System.out.println("E-mail acessado com sucesso\n");
    }
}
