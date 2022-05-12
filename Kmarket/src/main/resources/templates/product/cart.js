$(function(){
    		////////////////////////////////////
    		// 장바구니 전체합계
    		////////////////////////////////////
    		let total = $('.cart > form > .total'); 
    		let trs = $('.cart table > tbody > tr');
    		    		
    		// 상품 수 합계
    		let counts = trs.find('.count');
    		let totCount = 0;
    		
    		$.each(counts, function(){
    			let count = parseInt($(this).text());
    			totCount += count;    			
    		});
    		
    		console.log('totCount : '+totCount);
    		total.find('.count').text(totCount+'개');
    		
    		// 상품금액 합계
    		let prices = trs.find('.price');
    		let totPrice = 0;
    		
    		$.each(prices, function(){
    			let price = parseInt($(this).text().replace(/,/g, ''));
    			totPrice += price;    			
    		});
    		
    		console.log('totPrice : '+totPrice);
    		total.find('.price').text(totPrice.toLocaleString()+'원');
    		
    		// 할인금액 합계
    		let discounts = trs.find('.discount');
    		let totDiscount = 0;
    		
    		$.each(discounts, function(){
    			let price = parseInt($(this).prev().text().replace(/,/g, ''));
    			console.log('price : '+price);
    			
    			let discount = parseInt($(this).text().replace(/%/g, ''));
    			console.log('discount : '+discount);
    			
    			totDiscount += (price * discount / 100);
    			console.log('totDiscount : '+totDiscount);
    			
    		});
    		
    		console.log('totDiscount : '+totDiscount);
    		total.find('.discount').text(totDiscount.toLocaleString()+'원');
    		
    		// 배송비 합계
    		
    		// 포인트 합계
    		
    		// 전체주문금액 합계
    		
    		
    		
    		
    		
    	});