package com.example.gadsproject.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gadsproject.R;
import com.example.gadsproject.networkUtil.LeaderboardService;
import com.example.gadsproject.networkUtil.LeaderboardServiceBuilder;
import com.example.gadsproject.networkUtil.SubmitService;
import com.example.gadsproject.networkUtil.SubmitServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity
{
    private AlertDialog dialog;
    private ProgressBar progressBar;
    private EditText firstNameField, lastNameField, emailField, projectLinkField;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        progressBar = findViewById(R.id.progressBar);
        hideProgressBar();

        firstNameField = findViewById(R.id.firstname_edittext);
        lastNameField = findViewById(R.id.lastname_edittext);
        emailField = findViewById(R.id.email_edittext);
        projectLinkField = findViewById(R.id.project_link_edittext);
    }

    public void createDialog(View view)
    {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.confirm_submission_dialog);
        dialog = builder.create();
        dialog.show();
    }

    public void dismissDialog(View view)
    {
        dialog.dismiss();
    }

    public void dismissDialog()
    {
        dialog.dismiss();
    }

    public void showProgressBar()
    {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar()
    {
        progressBar.setVisibility(View.GONE);
    }

    public void submitEntries(View view)
    {
        dismissDialog();

        showProgressBar();

        SubmitService submitService = SubmitServiceBuilder.buildService(SubmitService.class);

        Call<Void> call = submitService.submitEntries(
                firstNameField.getText().toString(),
                lastNameField.getText().toString(),
                emailField.getText().toString(),
                projectLinkField.getText().toString()
        );

        call.enqueue(new Callback<Void>()
        {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response)
            {
                if (response.isSuccessful())
                {
                    hideProgressBar();

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubmitActivity.this);
                    builder.setView(R.layout.submission_successful_dialog);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable)
            {
                hideProgressBar();
                
                AlertDialog.Builder builder = new AlertDialog.Builder(SubmitActivity.this);
                builder.setView(R.layout.submission_unsuccessful_dialog);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}