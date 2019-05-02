class Favori implements IEntity{

	constructor($id: Number, $kullanici_id: Number, $favoritip: String, $favori_id: Number) {
		this.id = $id;
		this.kullanici_id = $kullanici_id;
		this.favoritip = $favoritip;
		this.favori_id = $favori_id;
	}
    private id:Number;
    private kullanici_id:Number;
    private favoritip:String;
    private favori_id:Number;
}