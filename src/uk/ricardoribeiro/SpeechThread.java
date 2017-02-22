package uk.ricardoribeiro;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * 
 * This Class extends Thread Class which let's 
 * us run the TTS without blocking the main gui thread
 * Once the Tread its done doing its job it self destroys . this.interrup():
 * This class uses the free TTS library to perform text to speech
 * http://freetts.sourceforge.net/docs/index.php#what_is_freetts
 * 
 * This class extends the thread class
 * A thread is a thread of execution in a program. 
 * The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.
 * 
 * @author Ricardo Ribeiro
 * @extends Thread
 */
public class SpeechThread extends Thread {
	 public String textToSpeek = "";
	 	public SpeechThread(String text)
	 	{
	 		textToSpeek = text;
	 	}
	 	// thread run method definition
	    public void run()
	    {
		   	  final String VOICENAME_kevin = "kevin16";
			  Voice voice;
			  VoiceManager voiceManager = VoiceManager.getInstance();
			  voice = voiceManager.getVoice(VOICENAME_kevin);
			  voice.allocate();
			  voice.speak(textToSpeek); 
			  this.interrupt();// interrupt the tread
	    }
 }