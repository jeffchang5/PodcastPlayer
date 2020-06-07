package io.jeffchang.nasademo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.jeffchang.nasademo.ui.photo.view.PhotoFragment
import io.jeffchang.nasademo.ui.photo.viewmodel.SortingStrategy
import kotlinx.android.synthetic.main.activity_main.*

class PhotoActivity() : AppCompatActivity(), PhotoFragment.Callback {

    private var onSortChangedListener: OnSortChangedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sort = when (item.itemId) {
            R.id.action_rover -> SortingStrategy.ROVER
            R.id.earth_date -> SortingStrategy.EARTH_DATE
            R.id.camera_type -> SortingStrategy.CAMERA_TYPE
            else -> return super.onOptionsItemSelected(item)
        }
        onSortChangedListener?.onSortChanged(sort)
        return true
    }


    override fun setOnSortChangedListener(onSortChangedListener: OnSortChangedListener?) {
        this.onSortChangedListener = onSortChangedListener
    }

    interface OnSortChangedListener {

        fun onSortChanged(sortingStrategy: SortingStrategy)

    }
}
