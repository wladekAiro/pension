// This is a manifest file that'll be compiled into application.js, which will include all the files
// listed below.
//
// Any JavaScript/Coffee file within this directory, lib/assets/javascripts, vendor/assets/javascripts,
// or vendor/assets/javascripts of plugins, if any, can be referenced here using a relative path.
//
// It's not advisable to add code directly here, but if you do, it'll appear at the bottom of the
// compiled file.
//
// Read Sprockets README (https://github.com/sstephenson/sprockets#sprockets-directives) for details
// about supported directives.
//
//= require jquery
//= require jquery_ujs
//= require jquery-ui
//= require moment
//= require bootstrap
//= require bootstrap-datetimepicker
//= require pickers
//= require bootstrap-sprockets
//= require bootstrap-datepicker
//= require dataTables/jquery.dataTables
//= require dataTables/bootstrap/3/jquery.dataTables.bootstrap
//  require dataTables/extras/dataTables.responsive
//= require cocoon
//= require_tree .
// JS debug
jQuery(document).ready(function() {
  // alert('loaded');
  // $('h1').css('color', 'green');
});



// Update product description
function update_product_desc(product_selection) {
  var prod_id = product_selection.find('select').val();

  $.getJSON( "/products/" + prod_id + ".json", function(data) {
    desc = data.description;
    product_selection.parent().find('td.item-desc span').html(desc);
  }); 

}


// Update product/unit price
function update_product_price(product_selection) {
  var prod_id = product_selection.find('select').val();

  $.getJSON( "/products/" + prod_id + ".json", function(data) {
    unit_price = data.price;
    product_selection.parent().find('td.item-price span').html(unit_price);
  });
}

// Update total price
function update_product_total(product_selection) {
  var prod_id = product_selection.find('select').val();
  var qty = product_selection.parent().find('td.item-qty input').val();

  $.getJSON( "/products/" + prod_id + ".json", function(data) {
    unit_price = data.price;
    prod_total = unit_price * qty;
    product_selection.parent().find('td.item-total-price span').html(prod_total);


    update_invoice_total();


  });
}


// Update invoice total cost
function update_invoice_total() {
  total = 0;
  $('table.invoice-items td.item-total-price span').each(function(){

    amount = Number($(this).text());
    if (amount != 'NaN') {
      total += amount;
    }

  });
  $('table.invoice-total span.total-amount').text(total);
}


jQuery(document).ready(function() {
  // add one inoice-item on load
  // $('div.add-invoice-item a.btn').click();


  // Update desc, price, total on document load
  $('table.invoice-items .item-id').each(function() {
    update_product_desc($(this));
    update_product_price($(this));
    update_product_total($(this));

    $(this).change(function() {
      update_product_desc($(this));
      update_product_price($(this));
      update_product_total($(this));
    });
  });

  $('table.invoice-items .item-qty').each(function() {
    $(this).change(function() {
      update_product_total($(this).parent().find('td.item-id'));
    });
  });

  
  // Update desc, price, total on add or remove
  $('table.invoice-items').on('cocoon:after-insert', function(e, insertedItem) {
    $('table.invoice-items .item-id').each(function() {
      update_product_desc($(this));
      update_product_price($(this));
      update_product_total($(this));

      $(this).change(function() {
        update_product_desc($(this));
        update_product_price($(this));
        update_product_total($(this));
      });
    });

    $('table.invoice-items .item-qty').each(function() {
      $(this).change(function() {
        update_product_total($(this).parent().find('td.item-id'));
      });
    });
  });
  
  $('table.invoice-items').on('cocoon:after-remove', function(e, insertedItem) {
    $('table.invoice-items .item-id').each(function() {
      update_product_desc($(this));
      update_product_price($(this));
      update_product_total($(this));

      $(this).change(function() {
        update_product_desc($(this));
        update_product_price($(this));
        update_product_total($(this));
      });
    });

    $('table.invoice-items .item-qty').each(function() {
      $(this).change(function() {
        update_product_total($(this).parent().find('td.item-id'));
      });
    });
  });


});



// Add search/filtering on Customers page (highlighting)
$(document).ready(function() {
  $('#customer-search-form input.customer-filter').keyup(function() {
    var sq = $(this).val().toLowerCase();

    // if (sq == "") { sq = "..."; }
    
    // $("#customer-search-form .searching-for").text(sq);

    $("table.customer-list tr").each(function(){
      //text().toLowerCase()
      var current_text = $(this).find('td.name,td.email,td.address').text().toLowerCase();
      // $("#customer-search-form .searching-for").text(current_text);
      if (sq.length > 0) {
        if (current_text.indexOf(sq) >= 0) {
          $(this).css('background', 'yellow');
        } else {
          $(this).css('background', 'inherit');
        }
      } else {
        $(this).css('background', 'inherit');
      }
    });

  });
});



// Invoices Page: invoice option buttons
$(document).ready(function() {

  // Email invoice pdf: add confirm dialog box
  $('p.invoice-minor-actions a.email-pdf').click(function(event){
    var send_pdf = confirm('Confirm sending this email?');
    if(send_pdf == false) {
      event.preventDefault();
    }

  });

  $('div.invoice-tab.unpaid-invoices').hide();
  $('div.invoice-tab.overdue-invoices').hide();

  $('div.invoice-options a').click(function(event){

    if ($(this).attr('href') == '#overdue-invoices') {
      alert("This feature is coming soon!");
    } else {

      $('div.invoice-options a').removeClass('active');
      $(this).addClass('active');

      var btn_target = $(this).attr('href').substring(1);

      $('div.invoice-tab').hide();

      $('div.invoice-tab').each(function() {
        if ($(this).hasClass(btn_target)) {
          $(this).show();
        }
      }); 

    }

    event.preventDefault();

  });

});


// Add table sorting via jQuery plugin
$(document).ready(function(){
  // Custom parser to counteract thousand separator commas
  $.tablesorter.addParser({ 
    // set a unique id 
    id: 'commas',
    is: function(s) { 
      // return false so this parser is not auto detected 
      return false; 
    }, 
    format: function(s) {
      // ignore '$' and ',' 
      return s.replace('$','').replace(/,/g,'');
    }, 
    // set type, either numeric or text 
    type: 'numeric' 
  });   

  /* Invoices */
  $('table.invoices thead th a').each(function(){
    $(this).click(function(event){
      event.preventDefault();
    });
  });
  $('table.invoices').tablesorter({
    headers: {
      2: { // zero-based column index
        sorter: 'commas'
      },
      3: {
        sorter: 'commas'
      }
    }
  });

  /* Customers */
  $('table.customer-list thead th a').each(function(){
    $(this).click(function(event){
      event.preventDefault();
    });
  });
  $('table.customer-list').tablesorter({
    headers: {
      3: {
        sorter: 'commas'
      }
    }
  });
});


// Add datepicker widget
//$(document).ready(function(){
//  $('input[type="date"]').datepicker({
//    dateFormat: "yy-mm-dd"
//  });
//});