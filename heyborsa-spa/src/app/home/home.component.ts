import { Component, OnInit } from '@angular/core';
declare var jQuery: any;
declare var $ : any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    if ($('#webticker-1').length) {   
      $("#webticker-1").webTicker({
        height:'auto', 
        duplicate:true, 
        startEmpty:false, 
        rssfrequency:5
      });
    }

    $('#example1').DataTable({
      'paging'      : false,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : false,
      'autoWidth'   : false
    });
  }

}
