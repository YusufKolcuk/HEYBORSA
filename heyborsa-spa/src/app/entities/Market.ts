export class Market implements IEntity {

	constructor(
		public id: Number, 
		public isim: String, 
		public tip: String, 
		public alis_deger: Number,
		public satis_deger:Number,
		public tarih: String) {}
}