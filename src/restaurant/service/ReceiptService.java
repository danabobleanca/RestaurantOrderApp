package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.dao.ReceiptDao;
import restaurant.model.Receipt;

@Service
public class ReceiptService {

	@Autowired 
	ReceiptDao receiptDao;
	
	public void save(Receipt receipt) {
		receiptDao.save(receipt);
	}
	public List<Receipt> getReceipts(){
		return receiptDao.getReceipts();
	}
}
