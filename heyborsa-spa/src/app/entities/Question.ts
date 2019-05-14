export class Question implements IEntity
{

	constructor($id: Number, $user_id: Number, $question_header: String, $question: String, $question_status: Number, $date: Date,$subject: String) {
		this.id = $id;
		this.user_id = $user_id;
		this.question_header = $question_header;
		this.question = $question;
		this.question_status = $question_status;
		this.date = $date;
		this.subject = $subject;
	}
    public id:Number;
	public user_id:Number;
	public subject:String;
    public question_header:String;
    public question:String;
    public question_status:Number;
    public date:Date;
}