package kr.ac.kpu.ce2019152012.hair_you.AR;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.SurfaceView;

import com.google.ar.sceneform.Sceneform;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;

import kr.ac.kpu.ce2019152012.hair_you.R;

public class SceneviewActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private ViewRenderable viewRenderable;
    private Renderable model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceneview);


        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arSceneviewFragment);
        //getSupportFragmentManager().addFragmentOnAttachListener(this);
        if (savedInstanceState == null) {
            if (Sceneform.isSupported(this)) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.arFragment, ArFragment.class, null)
                        .commit();
            }

        }


    }
}