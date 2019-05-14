export class Gold implements IEntity {
	
	public id: Number;
	public name: String; 
	public buying_price: Number;
	public selling_price: Number;
	public date: String
	
	constructor($id:Number, $name:String, $buying_price:Number, $selling_price:Number, $data:String)
		{
			this.id = $id;
			this.name = $name;
			this.buying_price = $buying_price;
			this.selling_price = $selling_price;
			this.date = $data;
		}
}