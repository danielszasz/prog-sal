package ro.scoalainformala.pojo;

public class SalSettings {

	private int id;
	private String userId;
	private int minSal;
	private int minSalEcon;
	private float averageHour;
	private int impSalar;
	private float casAng;
	private float casAsig;
	private float fondAcc;
	private float cassAng;
	private float cassAsig;
	private float concBoala;
	private float somAng;
	private float somAsig;
	private float fondGar;

	public SalSettings(int id, String userId, int minSal, int minSalEcon, float averageHour, int impSalar,
			float casAng, float casAsig, float fondAcc, float cassAng, float cassAsig, float concBoala, float somAng,
			float somAsig, float fondGar) {
		super();
		this.id = id;
		this.userId = userId;
		this.minSal = minSal;
		this.minSalEcon = minSalEcon;
		this.averageHour = averageHour;
		this.impSalar = impSalar;
		this.casAng = casAng;
		this.casAsig = casAsig;
		this.fondAcc = fondAcc;
		this.cassAng = cassAng;
		this.cassAsig = cassAsig;
		this.concBoala = concBoala;
		this.somAng = somAng;
		this.somAsig = somAsig;
		this.fondGar = fondGar;
	}
	public SalSettings() {
		super();
	}

	public SalSettings(String userId) {
		this(0, userId, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUser_id(String userId) {
		this.userId = userId;
	}

	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}

	public int getMinSalEcon() {
		return minSalEcon;
	}

	public void setMinSalEcon(int minSalEcon) {
		this.minSalEcon = minSalEcon;
	}

	public float getAverageHour() {
		return averageHour;
	}

	public void setAverageHour(float averageHour) {
		this.averageHour = averageHour;
	}

	public int getImpSalar() {
		return impSalar;
	}

	public void setImpSalar(int impSalar) {
		this.impSalar = impSalar;
	}

	public float getCasAng() {
		return casAng;
	}

	public void setCasAng(float casAng) {
		this.casAng = casAng;
	}

	public float getCasAsig() {
		return casAsig;
	}

	public void setCasAsig(float casAsig) {
		this.casAsig = casAsig;
	}

	public float getFondAcc() {
		return fondAcc;
	}

	public void setFondAcc(float fondAcc) {
		this.fondAcc = fondAcc;
	}

	public float getCassAng() {
		return cassAng;
	}

	public void setCassAng(float cassAng) {
		this.cassAng = cassAng;
	}

	public float getCassAsig() {
		return cassAsig;
	}

	public void setCassAsig(float cassAsig) {
		this.cassAsig = cassAsig;
	}

	public float getConcBoala() {
		return concBoala;
	}

	public void setConcBoala(float concBoala) {
		this.concBoala = concBoala;
	}

	public float getSomAng() {
		return somAng;
	}

	public void setSomAng(float somAng) {
		this.somAng = somAng;
	}

	public float getSomAsig() {
		return somAsig;
	}

	public void setSomAsig(float somAsig) {
		this.somAsig = somAsig;
	}

	public float getFondGar() {
		return fondGar;
	}

	public void setFondGar(float fondGar) {
		this.fondGar = fondGar;
	}
}
