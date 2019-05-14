export class User implements IEntity {

	constructor($id: Number, $name: String, $last_name: String, $email: String, $password: String, $telephone: Number, $date: Date, $active: boolean, $user_type: Number) {
		this.id = $id;
		this.name = $name;
		this.last_name = $last_name;
		this.email = $email;
		this.password = $password;
		this.telephone = $telephone;
		this.date = $date;
		this.active = $active;
		this.user_type = $user_type;
	}
	public id: Number;
	public name: String;
	public last_name: String;
	public email: String;
	public password: String;
	public telephone: Number;
	public date: Date;
	public active: boolean;
	public user_type: Number;


}