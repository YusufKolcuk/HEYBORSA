import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    console.log(value + " " + args);
    if(!args)
      return value;
    if(!Array.isArray(value))
      return value;
    if(args == undefined || value ==undefined)
      return value;
      if(args == null)
      return value;
    if(args && Array.isArray(value))
    {
      let filterKeys = Object.keys(args);  
        return value.filter(item=>{
          return filterKeys.some((keyName)=>{
            return new RegExp(args[keyName],'gi').test(item[keyName]) || args[keyName] == ""
          });
        })
      }
  }

}
