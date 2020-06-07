package io.jeffchang.nasademo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import io.jeffchang.nasademo.ui.photo.view.PhotoFragment
import io.jeffchang.nasademo.ui.photo.viewmodel.SortingStrategy
import kotlinx.android.synthetic.main.activity_main.*

class PhotoActivity : AppCompatActivity(), PhotoFragment.Callback {

    private var onActivityUiInteraction: OnActivityUiInteraction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initDebugFAB()
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
        onActivityUiInteraction?.onSortChanged(sort)
        return true
    }

    override fun setOnSortChangedListener(onActivityUiInteraction: OnActivityUiInteraction?) {
        this.onActivityUiInteraction = onActivityUiInteraction
    }

    private fun initDebugFAB() {
        var useMalformed = false
        debugFab.isVisible = BuildConfig.DEBUG
        debugFab.setOnClickListener {
            useMalformed = !useMalformed
            val message =
                if (useMalformed) "Using data with Missing Data"
                else "Using correct data"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val id = if (useMalformed) {
                R.drawable.ic_baseline_check_24
            } else {
                R.drawable.ic_baseline_close_24
            }
            val drawable = ContextCompat.getDrawable(this, id)
            debugFab.setImageDrawable(drawable)
            onActivityUiInteraction?.onUseMalformedChanged(useMalformed)
        }
    }

    interface OnActivityUiInteraction {

        fun onUseMalformedChanged(useMalformed: Boolean)

        fun onSortChanged(sortingStrategy: SortingStrategy)

    }
}
