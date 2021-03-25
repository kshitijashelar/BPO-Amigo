function isNumberKey(evt)
{
        var charCode = (evt.which) ? evt.which : event.keyCode;
        //alert("Number"+charCode);
        if (charCode > 31 && (charCode < 48 || charCode > 57))
           return false;

        return true;
}

function isCharacterKey(evt)
{
	
        var charCode = (evt.which) ? evt.which : event.keyCode;
       //alert("Char"+charCode);
        if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <=122) || charCode==8)
           return true;

        return false;
}

function isParagraphWriter(evt)
{
	
        var charCode = (evt.which) ? evt.which : event.keyCode;
       //alert("Char"+charCode);
        if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <=122) || charCode==08 || charCode==32 || charCode==46 || charCode==44)
           return true;

        return false;
}

function validateUsername(evt)
{
	
        var charCode = (evt.which) ? evt.which : event.keyCode;
       //alert("Char"+charCode);
        if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <=122) || (charCode >= 48 && charCode <= 57))
           return true;

        return false;
}