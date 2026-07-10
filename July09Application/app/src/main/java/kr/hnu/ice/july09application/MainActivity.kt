package kr.hnu.ice.july09application

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kr.hnu.ice.july09application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this, "Back button pressed", Toast.LENGTH_SHORT).show()
        binding.textView.text = "뒤로 가기 버튼이 눌렸습니다."
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuItem1: MenuItem? = menu?.add(Menu.NONE, 1, Menu.NONE, "메뉴 1")
        val menuItem2: MenuItem? = menu?.add(Menu.NONE, 2, Menu.NONE, "메뉴 2")
        val menuItem3: MenuItem? = menu?.add(Menu.NONE, 3, Menu.NONE, "메뉴 3")

        val searchItem = menu?.add(Menu.NONE, 4, Menu.NONE, "검색")
        searchItem?.setIcon(android.R.drawable.ic_menu_search)
        searchItem?.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)

        val searchView = SearchView(this)
        searchView.queryHint = "검색어를 입력하세요"
        searchItem?.actionView = searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity, "검색어: $query", Toast.LENGTH_SHORT).show()
                binding.textView.text = "검색어: $query"
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(this@MainActivity, "검색어 변경: $newText", Toast.LENGTH_SHORT).show()
                binding.textView.text = "검색어 변경: $newText"
                return true
            }
        })
            return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                Toast.makeText(this, "메뉴 1이 선택되었습니다.", Toast.LENGTH_SHORT).show()
                binding.textView.text = "메뉴 1이 선택되었습니다."
                return true
            }
            2 -> {
                Toast.makeText(this, "메뉴 2가 선택되었습니다.", Toast.LENGTH_SHORT).show()
                binding.textView.text = "메뉴 2가 선택되었습니다."
                return true
            }
            3 -> {
                Toast.makeText(this, "메뉴 3이 선택되었습니다.", Toast.LENGTH_SHORT).show()
                binding.textView.text = "메뉴 3이 선택되었습니다."
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    
}