function Alert(attr, header, message){
	var divTag = $(document.createElement('div')).attr('class', 'alert ' + attr);
	var aTag = $(document.createElement('a')).attr('class', 'close').attr('data-dismiss', 'alert').attr('aria-label', 'close').html('&times;');
	var strongTag = $(document.createElement('strong')).html(header);
	return $(divTag).append(aTag).append(strongTag).append('<br/>').append(message);
}

var success = 'alert-success';
var warning = 'alert-warning';
var info = 'alert-info';
var danger = 'alert-danger';
