/**
 * 
 */
package com.xtel.examthread.bai6c;

/**
 * @author TUAN
 *
 */
public class ThreadConsumer extends Thread {
	
	QueueMessage queueMessage = new QueueMessage();

	public ThreadConsumer(QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Chuoi: %s", queueMessage.queueMessage.poll()));
		
	}
}
