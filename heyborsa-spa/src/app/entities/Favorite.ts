export class Favorite implements IEntity{

	constructor($id: Number, $user_id: Number, $favori_type: String, $favori_id: Number) {
		this.id = $id;
		this.user_id = $user_id;
		this.favori_type = $favori_type;
		this.favori_id = $favori_id;
	}
    private id:Number;
    private user_id:Number;
    private favori_type:String;
    private favori_id:Number;
}