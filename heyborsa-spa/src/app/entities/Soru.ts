class Soru implements IEntity
{

	constructor($id: Number, $kullanici_id: Number, $soru_baslik: String, $soru: String, $soru_durum: Number, $tarih: Date) {
		this.id = $id;
		this.kullanici_id = $kullanici_id;
		this.soru_baslik = $soru_baslik;
		this.soru = $soru;
		this.soru_durum = $soru_durum;
		this.tarih = $tarih;
	}
    private id:Number;
    private kullanici_id:Number;
    private soru_baslik:String;
    private soru:String;
    private soru_durum:Number;
    private tarih:Date;
}