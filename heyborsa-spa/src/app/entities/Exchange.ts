export class Exchange implements IEntity {
	
		public id: Number;
		public name: String; 
		public value: Number;
		public volume: Number;
		public date: String
		constructor($id:Number, $name:String, $value:Number, $volume:Number, $data:String)
		{
			this.id = $id;
			this.name = $name;
			this.value = $value;
			this.volume = $volume;
			this.date = $data;
		}
}