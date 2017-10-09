package wsl.eletrovision.controle.recursos;

public class ConstantesTelas {

	//Dialogs
	public static final int DIALOG_SIM_NAO = 1; 
	public static final int DIALOG_LISTA = 2; 
	public static final int DIALOG_ENTRADA = 3; 
	public static final int DIALOG_DESCONECTAR = 4;  
	
	//Handle
	public static final int HD_CONECTAR = 1; 
	public static final int HD_MENSAGEM = 2; 
	public static final int HD_CENARIO = 3;
	public static final int HD_CENARIO_PREENCHER_LISTA = 4;
	public static final int HD_DISPOSITIVO = 5;
	public static final int HD_DISPOSITIVO_PREENCHER_LISTA = 6;
	public static final int HD_CAMERA = 7;
	public static final int HD_CAMERA_PREENCHER_LISTA = 8;
	public static final int HD_USUARIOS = 9; 
	public static final int HD_LOCALIZACAO_USUARIO = 10; 
	public static final int HD_CONFIG_CAMERA = 11;
	public static final int HD_CONFIG_CENARIO = 12;
	public static final int HD_ATUALIZAR_REDE = 13; 
	public static final int HD_ULTIMA_FOTO = 14; 
	
	//Bunble
	public static final String BD_CONFIRMACAO_CONEXAO = "bd1"; 
	public static final String BD_CONFIRMACAO_CENARIO = "bd2"; 
	public static final String BD_CONFIRMACAO_DISPOSITIVO = "bd3"; 
	public static final String BD_CONFIRMACAO_CAMERA = "bd4"; 
	public static final String BD_CONFIG_CAMERA_CODIGO = "bd5";
	public static final String BD_CONFIG_CAMERA_LISTA = "bd6"; 
	public static final String BD_CONFIG_CENARIO_CODIGO = "bd7";
	public static final String BD_CONFIG_CENARIO_LISTA = "bd8"; 
	public static final String BD_MAPA_LATITUDE = "bd9"; 
	public static final String BD_MAPA_LONGITUDE = "bd10"; 
	public static final String BD_CONFIRMACAO_LOCALIZACAO = "bd11"; 
	public static final String BD_ACESSO = "bd12"; 
	public static final String BD_ULTIMA_FOTO = "bd13";
	
	//Results
	public static final int RS_CONECTADO = 1; 
	
	//Preferencias
	public final static String PF_NOME_PREFERENCIA = "config";
	public final static String PF_LOCALIZACAO_GPS = "pf_1";
	public final static String PF_AUDIO = "pf_2";
	
}
