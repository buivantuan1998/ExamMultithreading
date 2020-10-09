/**
 * 
 */
package com.xtel.examthread.bai6c;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author TUAN
 *
 */
public class ThreadProducer extends Thread {

	Message message = new Message();
	QueueMessage queueMessage = new QueueMessage();
	private QueueMessage queueData;

	public ThreadProducer(QueueMessage queueData) {
		this.queueData = queueData;
	}

	
	Random random = new Random();

	@Override
	public void run() {
		
		Random random = new Random();
		String customerName = " ";
		String giftName = " ";
		message.dataMessage();
		int i = 0;
	
		do {
			for (i = 0; i < message.listCustomerName.size(); i++) {
				customerName = message.listCustomerName.get(random.nextInt(message.listCustomerName.size()));
			}
			
			for (i = 0; i < message.listGiftName.size(); i++) {
				giftName = message.listGiftName.get(random.nextInt(message.listGiftName.size()));
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String listInfo = String.format("Chuc mung %s la khach hang may man man nhan duoc %s tu chuong trinh tri an khach hang", 
					customerName, giftName);
			queueMessage.queueMessage.offer(listInfo);
//			System.out.println(listInfo);
//			System.out.println(String.format("Chuoi: %s", queueMessage.queueMessage.poll()));
		} while (true);
		
	}

	public static void main(String[] args) {
		QueueMessage queueMessage = new QueueMessage();
		ThreadProducer t = new ThreadProducer(queueMessage);
		t.start();

	}

}
