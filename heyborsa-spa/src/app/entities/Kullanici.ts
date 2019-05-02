class Kullanici implements IEntity {

	constructor($id: Number, $isim: String, $soyisim: String, $eposta: String, $sifre: String, $telefon: Number, $tarih: Date, $aktif: boolean, $kullanicitip: Number) {
		this.id = $id;
		this.isim = $isim;
		this.soyisim = $soyisim;
		this.eposta = $eposta;
		this.sifre = $sifre;
		this.telefon = $telefon;
		this.tarih = $tarih;
		this.aktif = $aktif;
		this.kullanicitip = $kullanicitip;
	}
	private id: Number;
	private isim: String;
	private soyisim: String;
	private eposta: String;
	private sifre: String;
	private telefon: Number;
	private tarih: Date;
	private aktif: boolean;
	private kullanicitip: Number;


}