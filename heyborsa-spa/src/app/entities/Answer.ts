export class Answer implements IEntity
{

	constructor($id: Number, $question_id: Number, $answer: String, $question: String, $fu_id: Number, $date: Date) {
		this.id = $id;
		this.question_id = $question_id;
		this.answer = $answer;
		this.fu_id = $fu_id;
		this.date = $date;
	}
    public id:Number;
	public question_id:Number;
	public answer:String;
    public date:Date;
    public fu_id:Number;

}