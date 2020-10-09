/**
 * 
 */
package com.xtel.examthread.bai6c;

/**
 * @author TUAN
 *
 */
public class Main {

	public static void main(String[] args) {
		Message message = new Message();
		QueueMessage queueMessage = new QueueMessage();
		ThreadProducer threadProducer = new ThreadProducer(queueMessage);
		ThreadConsumer threadConsumer = new ThreadConsumer(queueMessage);
		
		message.dataMessage();
		threadProducer.start();
		threadConsumer.start();
	}

}
