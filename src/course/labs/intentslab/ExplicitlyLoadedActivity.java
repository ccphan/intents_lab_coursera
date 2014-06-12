package course.labs.intentslab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitlyLoadedActivity extends Activity {

	static private final String TAG = "Lab-Intents";

	private EditText mEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.explicitly_loaded_activity);

		// Get a reference to the EditText field
		mEditText = (EditText) findViewById(R.id.editText);

		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.enter_button);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			@Override
			public void onClick(View v) {

				enterClicked();
			
			}
		});

	}

	// Sets result to send back to calling Activity and finishes
	
	private void enterClicked() {

		Log.i(TAG,"Entered enterClicked()");
		
		// TODO - Save user provided input from the EditText field
		 Editable msg = mEditText.getText();

		// TODO - Create a new intent and save the input from the EditText field as an extra
		// Note that you don't need to explicitly specify which activity to call when creating this intent
		// As the "ActivityLoaderActivity.class (caller) would be the next activity on the back-stack
		// This activity should be 'active' when this activity calls the finish()
		 Intent intent = new Intent();
		 intent.putExtra("course.labs.intentslab.text",msg.toString());
		
		// TODO - Set Activity's result with result code RESULT_OK
		 this.setResult(RESULT_OK, intent);
		
		// TODO - Finish the Activity
		 finish();

	}
}
