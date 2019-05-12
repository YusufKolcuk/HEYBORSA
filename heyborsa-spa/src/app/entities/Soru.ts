class Soru implements IEntity
{

	constructor($id: Number, $kullanici_id: Number, $soru_baslik: String, $soru: String, $soru_durum: Number, $tarih: Date,$konu: String) {
		this.id = $id;
		this.kullanici_id = $kullanici_id;
		this.soru_baslik = $soru_baslik;
		this.soru = $soru;
		this.soru_durum = $soru_durum;
		this.tarih = $tarih;
		this.konu = $konu;
	}
    public id:Number;
	public kullanici_id:Number;
	public konu:String;
    public soru_baslik:String;
    public soru:String;
    public soru_durum:Number;
    public tarih:Date;
}