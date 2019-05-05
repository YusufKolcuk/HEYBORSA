export class Borsa implements IEntity {

	constructor(
		public id: Number, 
		public isim: String, 
		public deger: Number,
		public hacim: Number,
		public tarih: String) {}
}