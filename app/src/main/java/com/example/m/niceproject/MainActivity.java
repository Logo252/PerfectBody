package com.example.m.niceproject;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import android.widget.Toast;

import com.example.m.niceproject.exercises.Abdominal;
import com.example.m.niceproject.exercises.Back;
import com.example.m.niceproject.exercises.Biceps;
import com.example.m.niceproject.exercises.Chest;
import com.example.m.niceproject.exercises.Legs;
import com.example.m.niceproject.exercises.Shoulders;
import com.example.m.niceproject.exercises.Triceps;
import com.example.m.niceproject.exercises.abdominalExercises.AbRoller;
import com.example.m.niceproject.exercises.abdominalExercises.BentKneeHitRaise;
import com.example.m.niceproject.exercises.abdominalExercises.BicycleCrunches;
import com.example.m.niceproject.exercises.abdominalExercises.BottomsUpStanding;
import com.example.m.niceproject.exercises.abdominalExercises.CableSeatedCrunches;
import com.example.m.niceproject.exercises.abdominalExercises.CableTwists;
import com.example.m.niceproject.exercises.abdominalExercises.Chrunches;
import com.example.m.niceproject.exercises.abdominalExercises.DeclineObliqueCrunches;
import com.example.m.niceproject.exercises.abdominalExercises.Plank;
import com.example.m.niceproject.exercises.abdominalExercises.ToeToucherCrunches;
import com.example.m.niceproject.exercises.abdominalExercises.VupAbs;
import com.example.m.niceproject.exercises.backExercises.CloseGripPullDown;
import com.example.m.niceproject.exercises.backExercises.DeadLift;
import com.example.m.niceproject.exercises.backExercises.HyperExtension;
import com.example.m.niceproject.exercises.backExercises.PullDownBehindNeck;
import com.example.m.niceproject.exercises.backExercises.PullUps;
import com.example.m.niceproject.exercises.backExercises.ReverseGripBentOver;
import com.example.m.niceproject.exercises.backExercises.SeatedCableRowing;
import com.example.m.niceproject.exercises.bicepsExercises.AlternateDumbbellCurl;
import com.example.m.niceproject.exercises.bicepsExercises.BarbellCurl;
import com.example.m.niceproject.exercises.bicepsExercises.CableBicepsCurl;
import com.example.m.niceproject.exercises.bicepsExercises.CloseGripBarbellCurl;
import com.example.m.niceproject.exercises.bicepsExercises.ConcentrationCurl;
import com.example.m.niceproject.exercises.bicepsExercises.CrossBodyHammerCurl;
import com.example.m.niceproject.exercises.bicepsExercises.HammerCurls;
import com.example.m.niceproject.exercises.bicepsExercises.HighCableCurls;
import com.example.m.niceproject.exercises.bicepsExercises.InclineHammerCurl;
import com.example.m.niceproject.exercises.bicepsExercises.OverHeadCableCurls;
import com.example.m.niceproject.exercises.chestExercises.Butterfly;
import com.example.m.niceproject.exercises.chestExercises.DeclineBarbellPullOver;
import com.example.m.niceproject.exercises.chestExercises.DeclineBenchBarbellPress;
import com.example.m.niceproject.exercises.chestExercises.DeclineBenchDumbbellPress;
import com.example.m.niceproject.exercises.chestExercises.DeclinePushUps;
import com.example.m.niceproject.exercises.chestExercises.DumbbellPullOver;
import com.example.m.niceproject.exercises.chestExercises.InclineBenchBarbellPress;
import com.example.m.niceproject.exercises.chestExercises.InclineBenchDumbbellFlies;
import com.example.m.niceproject.exercises.chestExercises.PlainBenchBarbellPress;
import com.example.m.niceproject.exercises.chestExercises.PlainBenchDumbbellPress;
import com.example.m.niceproject.exercises.chestExercises.SingleArmPushUps;
import com.example.m.niceproject.exercises.legsExercises.WideStanceBarbellSquat;
import com.example.m.niceproject.exercises.legsExercises.BarbellWalking;
import com.example.m.niceproject.exercises.legsExercises.DonkeyCalfRaise;
import com.example.m.niceproject.exercises.legsExercises.DumbbellRearWalking;
import com.example.m.niceproject.exercises.legsExercises.Jogging;
import com.example.m.niceproject.exercises.legsExercises.LegExtension;
import com.example.m.niceproject.exercises.legsExercises.LegPress;
import com.example.m.niceproject.exercises.legsExercises.SideLegRaise;
import com.example.m.niceproject.exercises.legsExercises.SmithMachineCalfRaise;
import com.example.m.niceproject.exercises.legsExercises.SmithMachineSquat;
import com.example.m.niceproject.exercises.shouldersExercises.AlternateDeltoidRaise;
import com.example.m.niceproject.exercises.shouldersExercises.BarbellShoulderPress;
import com.example.m.niceproject.exercises.shouldersExercises.DumbbellShoulderPress;
import com.example.m.niceproject.exercises.shouldersExercises.Shrugs;
import com.example.m.niceproject.exercises.shouldersExercises.SingleHandDumbbellFrontRaise;
import com.example.m.niceproject.exercises.shouldersExercises.SmithMachineBackShrugs;
import com.example.m.niceproject.exercises.shouldersExercises.SmithMachineShrugs;
import com.example.m.niceproject.exercises.shouldersExercises.StandingAlternateDumbbellPress;
import com.example.m.niceproject.exercises.tricepsExercises.BenchDips;
import com.example.m.niceproject.exercises.tricepsExercises.CableOverheadTricepsExtension;
import com.example.m.niceproject.exercises.tricepsExercises.CloseGripDumbbellPress;
import com.example.m.niceproject.exercises.tricepsExercises.CloseGripDumbbellPushUps;
import com.example.m.niceproject.exercises.tricepsExercises.CloseGripEzBarBenchPress;
import com.example.m.niceproject.exercises.tricepsExercises.DeclineEzBarTricepsExtension;
import com.example.m.niceproject.exercises.tricepsExercises.DumbbellOneArmTricepsExtension;
import com.example.m.niceproject.exercises.tricepsExercises.LyingTricepsExtensions;
import com.example.m.niceproject.exercises.tricepsExercises.RopeTricepsPushDown;
import com.example.m.niceproject.exercises.tricepsExercises.SeatedDumbbellTricepsPress;
import com.example.m.niceproject.exercises.tricepsExercises.StandingBarbellTricepsExtension;
import com.example.m.niceproject.exercises.tricepsExercises.StandingTricepsKickBack;
import com.example.m.niceproject.exercises.tricepsExercises.TricepsDips;
import com.example.m.niceproject.nutrition.Diets;
import com.example.m.niceproject.nutrition.EssentialNutrients;
import com.example.m.niceproject.nutrition.Food;
import com.example.m.niceproject.nutrition.diets.BurnMoreFat;
import com.example.m.niceproject.nutrition.diets.HealthiestSummerFruits;
import com.example.m.niceproject.nutrition.diets.LoseWeight;
import com.example.m.niceproject.nutrition.diets.TruthAboutDiets;
import com.example.m.niceproject.nutrition.essentialNutritents.Carbohydrates;
import com.example.m.niceproject.nutrition.essentialNutritents.CholesterolNeedToKnow;
import com.example.m.niceproject.nutrition.essentialNutritents.ManipulatingHormones;
import com.example.m.niceproject.nutrition.essentialNutritents.Vegetables;
import com.example.m.niceproject.nutrition.food.DrinkWater10;
import com.example.m.niceproject.nutrition.food.HealthySnacks8;
import com.example.m.niceproject.nutrition.food.ProteinNeverTried;
import com.example.m.niceproject.nutrition.food.WaterInOurBody;


public class MainActivity extends AppCompatActivity  {

    private CoordinatorLayout coordinatorLayout;
    private DrawerLayout mDrawerLayout;
    private ViewPager viewPager;

    private TabLayout tabLayout;
    private FrameLayout container;
    private Toolbar toolbar;


    // EXERCISES CONSTANTS
    private final static String ABDOMINAL_TAG = "ABDOMINAL";
    private final static String BACK_TAG = "BACK";
    private final static String BICEPS_TAG = "BICEPS";
    private final static String CHEST_TAG = "CHEST";
    private final static String LEGS_TAG = "LEGS";
    private final static String SHOULDERS_TAG = "SHOULDERS";
    private final static String TRICEPS_TAG = "TRICEPS";

    // NUTRITION CONSTANTS
    private final static String DIETS_TAG = "DIETS";
    private final static String ESSENTIAL_NUTRITENTS_TAG = "ESSENTIAL_NUTRITIENTS";
    private final static String FOOD_TAG = "FOODS";


    private final static String ABOUT_TAG = "ABOUT";
    private final static String RATE_TAG = "RATE";
    // SAVING AND RESTORING PROFILE FRAGMENT STATE
    private ProfileFragment profileFragment;
    private final static String PROFILE_TAG = "PROFILE";
    private Bundle fragmentState;


    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fragmentState = savedInstanceState;
        //-------------------------------------------------------------------------------


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.tab_layout);


        //AppRater.app_launched(this); // Rating app ...



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        container = (FrameLayout) findViewById(R.id.flContent);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //tabLayout.setupWithViewPager(viewPager);


        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){

            //actionBar.setHomeAsUpIndicator(R.drawable.menu_select);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_more);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }


        // CALLING fragment when creating main activity ------------------------------------------------
        mDrawerLayout.closeDrawers();

        viewPager.setVisibility(View.VISIBLE);

        container.setVisibility(View.GONE);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabHomeFragment(), "HOME");
        adapter.addFrag(new TabExercisesFragment(), "EXERCISES");
        adapter.addFrag(new TabNutritionFragment(), "NUTRITION");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




        // CONNECTIVITY IS CALLED WHEN APP LAUNCHES FIRST TIME-------------------------------------------------------------------------------------
        if (Connectivity.isConnected(this)){ // if there is connectivity

            if (Connectivity.isConnectedMobile(this) ){ // MOBILE

                Toast.makeText(getApplicationContext(),
                        "Connected to mobile network!",
                        Toast.LENGTH_LONG).show();

            }
            else if (Connectivity.isConnectedWifi(this) ){ // WIFI

                Toast.makeText(getApplicationContext(),
                        "Connected to wifi network!",
                        Toast.LENGTH_LONG).show();
            }



        }
        else {                               // if there is no connectivity
            Toast.makeText(getApplicationContext(),
                    "Not connected to network!",
                    Toast.LENGTH_LONG).show();

        }


        //--------------------------------------------------------------------------------

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                                             @Override
                                                             public boolean onNavigationItemSelected(MenuItem menuItem) {

                                                                 //hideSoftKeyboard(MainActivity.this);

                                                                 menuItem.setChecked(true);
                                                                 mDrawerLayout.closeDrawers();


                                                                 int mNavItemId = menuItem.getItemId();



                                                                 //------------------------------------------------------------------

                                                                 viewPager.setVisibility(View.GONE);
                                                                 container.setVisibility(View.VISIBLE);

                                                                 tabLayout.setVisibility(View.GONE);


                                                                 if (mNavItemId == R.id.my_profile) {

                                                                     // CHECKING  that we aren't unnecessarily recreating the fragment on configuration changes
                                                                     if (fragmentState != null) { // saved instance state, fragment may exist
                                                                         // look up the instance that already exists by tag
                                                                         profileFragment = (ProfileFragment)
                                                                                 getSupportFragmentManager().findFragmentByTag(PROFILE_TAG);
                                                                     } else if (profileFragment == null) {
                                                                         // only create fragment if they haven't been instantiated already
                                                                         profileFragment = new ProfileFragment();
                                                                     }


                                                                     FragmentManager fragmentManager = getSupportFragmentManager();
                                                                     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                                                                     fragmentTransaction.replace(R.id.flContent, profileFragment, PROFILE_TAG);
                                                                     fragmentTransaction.addToBackStack(null);
                                                                     fragmentTransaction.commit();


                                                                 } else if (mNavItemId == R.id.my_home) {

                                                                     viewPager.setVisibility(View.VISIBLE);
                                                                     container.setVisibility(View.GONE);
                                                                     tabLayout.setVisibility(View.VISIBLE);

                                                                     getHomeTab();
                                                                     /* viewPager = (ViewPager) findViewById(R.id.view_pager);
                                                                     ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
                                                                     adapter.addFrag(new TabHomeFragment(), "HOME");
                                                                     adapter.addFrag(new TabExercisesFragment(), "EXERCISES");
                                                                     adapter.addFrag(new TabNutritionFragment(), "NUTRITION");
                                                                     viewPager.setAdapter(adapter);
                                                                     tabLayout.setupWithViewPager(viewPager); */

                                                                 } else if (mNavItemId == R.id.myAbout) {

                                                                     FragmentManager fragmentManager = getSupportFragmentManager();
                                                                     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                                                     AboutFragment fragment = new AboutFragment();
                                                                     fragmentTransaction.replace(R.id.flContent, fragment, ABOUT_TAG);
                                                                     fragmentTransaction.addToBackStack(null);
                                                                     fragmentTransaction.commit();


                                                                 } else if (mNavItemId == R.id.my_rate_app) {


                                                                     FragmentManager fragmentManager = getSupportFragmentManager();
                                                                     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                                                     RateAppFragment fragment = new RateAppFragment();
                                                                     fragmentTransaction.replace(R.id.flContent, fragment, RATE_TAG);
                                                                     fragmentTransaction.addToBackStack(null);
                                                                     fragmentTransaction.commit();


                                                                 }


                                                                 return true;

                                                             }

                                                         }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    // HANDLE SEARCH -------------------------------------------------------------------------------------------------
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {


        return super.onPrepareOptionsMenu(menu);
    }

    //----------------------------------------------------------------------------------------------------------------
    // HIDE KEYBOARD
    /* public static void hideSoftKeyboard(AppCompatActivity activity) {

        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    } */


    //----------------------------------------------------------------------------------------------------------------
    public void replaceTabExercisesFragment(int position){

        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        viewPager.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);

        tabLayout.setVisibility(View.GONE);

        if (position == 0){

            fragment = new Abdominal();
            transaction.replace(R.id.flContent, fragment, ABDOMINAL_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }
        else if (position == 1){

            fragment = new Back();
            transaction.replace(R.id.flContent, fragment, BACK_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }
        else if (position == 2){

            fragment = new Biceps();
            transaction.replace(R.id.flContent, fragment, BICEPS_TAG);
            transaction.addToBackStack(null);
            transaction.commit();


        }
        else if (position == 3){

            fragment = new Chest();
            transaction.replace(R.id.flContent, fragment, CHEST_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }
        else if (position == 4){

            fragment = new Legs();
            transaction.replace(R.id.flContent, fragment, LEGS_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }
        else if (position == 5){

            fragment = new Shoulders();
            transaction.replace(R.id.flContent, fragment, SHOULDERS_TAG);
            transaction.addToBackStack(null);
            transaction.commit();


        }
        else if (position == 6){

            fragment = new Triceps();
            transaction.replace(R.id.flContent, fragment, TRICEPS_TAG);
            transaction.addToBackStack(null);
            transaction.commit();


        }

    }

    public void replaceTabNutritionFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        viewPager.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);

        tabLayout.setVisibility(View.GONE);

        if (position == 0){

            fragment = new Diets();
            transaction.replace(R.id.flContent, fragment, DIETS_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }
        else if (position == 1){

            fragment = new Food();
            transaction.replace(R.id.flContent, fragment, FOOD_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }
        else if (position == 2){

            fragment = new EssentialNutrients();
            transaction.replace(R.id.flContent, fragment, ESSENTIAL_NUTRITENTS_TAG);
            transaction.addToBackStack(null);
            transaction.commit();



        }

    }

    //-----------------------------------------------------------------------------------------------
    public void backToHome(){

        viewPager.setVisibility(View.VISIBLE);
        container.setVisibility(View.GONE);
        tabLayout.setVisibility(View.VISIBLE);

        /* viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager() );
        adapter.addFrag(new TabHomeFragment(), "HOME");
        adapter.addFrag(new TabExercisesFragment(), "EXERCISES");
        adapter.addFrag(new TabNutritionFragment(), "NUTRITION");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager); */


    }

    public void getFitnessTab(){

        TabLayout.Tab tab = tabLayout.getTabAt(1);

        if (tab != null)
           tab.select();

    }

    public void getNutritionTab(){

        TabLayout.Tab tab = tabLayout.getTabAt(2);

        if (tab != null)
            tab.select();

    }

    public void getHomeTab(){

        TabLayout.Tab tab = tabLayout.getTabAt(0);

        if (tab != null)
            tab.select();

    }

    //-----------------------------------------------------------------------------------------------
    @Override
    public void onBackPressed() {

        // EXERCISES
        Abdominal abdominalFragment = (Abdominal)getSupportFragmentManager().findFragmentByTag(ABDOMINAL_TAG);
        if (abdominalFragment != null && abdominalFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        Back backFragment = (Back)getSupportFragmentManager().findFragmentByTag(BACK_TAG);
        if (backFragment != null && backFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        Biceps bicepsFragment = (Biceps)getSupportFragmentManager().findFragmentByTag(BICEPS_TAG);
        if (bicepsFragment != null && bicepsFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        Chest chestFragment = (Chest)getSupportFragmentManager().findFragmentByTag(CHEST_TAG);
        if (chestFragment != null && chestFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        Legs legsFragment = (Legs)getSupportFragmentManager().findFragmentByTag(LEGS_TAG);
        if (legsFragment != null && legsFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        Shoulders shouldersFragment = (Shoulders)getSupportFragmentManager().findFragmentByTag(SHOULDERS_TAG);
        if (shouldersFragment != null && shouldersFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        Triceps tricepsFragment = (Triceps)getSupportFragmentManager().findFragmentByTag(TRICEPS_TAG);
        if (tricepsFragment != null && tricepsFragment.isVisible() ) {
            backToHome();
            getFitnessTab();
        }

        // NUTRITION
        Diets dietsFragment = (Diets)getSupportFragmentManager().findFragmentByTag(DIETS_TAG);
        if (dietsFragment != null && dietsFragment.isVisible() ) {
            backToHome();
            getNutritionTab();
        }

        EssentialNutrients essentialNutrientsFragment = (EssentialNutrients)getSupportFragmentManager().findFragmentByTag(ESSENTIAL_NUTRITENTS_TAG);
        if (essentialNutrientsFragment != null && essentialNutrientsFragment.isVisible() ) {
            backToHome();
            getNutritionTab();
        }

        Food foodFragment = (Food)getSupportFragmentManager().findFragmentByTag(FOOD_TAG);
        if (foodFragment != null && foodFragment.isVisible() ) {
            backToHome();
            getNutritionTab();
        }

        // NAVIGATION MENU
        AboutFragment aboutFragment = (AboutFragment)getSupportFragmentManager().findFragmentByTag(ABOUT_TAG);
        if (aboutFragment != null && aboutFragment.isVisible() ) {
            backToHome();
            getHomeTab();
        }

        RateAppFragment rateAppFragment = (RateAppFragment)getSupportFragmentManager().findFragmentByTag(RATE_TAG);
        if (rateAppFragment != null && rateAppFragment.isVisible() ) {
            backToHome();
            getHomeTab();
        }

        profileFragment = (ProfileFragment)getSupportFragmentManager().findFragmentByTag(PROFILE_TAG);
        if (profileFragment != null && profileFragment.isVisible() ) {
            backToHome();
            getHomeTab();
        }

        // TABS ------------------------------------------
        TabExercisesFragment exercisesFragment = (TabExercisesFragment)getSupportFragmentManager().findFragmentById(R.id.exercisesFragment);
        if (exercisesFragment != null && exercisesFragment.isVisible() ) {
            super.onBackPressed();
        }

        TabNutritionFragment nutritionFragment = (TabNutritionFragment)getSupportFragmentManager().findFragmentById(R.id.nutritionFragment);
        if (nutritionFragment != null && nutritionFragment.isVisible() ) {
            super.onBackPressed();
        }

        TabHomeFragment homeFragment = (TabHomeFragment)getSupportFragmentManager().findFragmentById(R.id.homeFragment);
        if (homeFragment != null && homeFragment.isVisible() ) {
            super.onBackPressed();
        }


        //HANDLING back pressed---------------------------------------
        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {

            super.onBackPressed();
        }
        else {

            getSupportFragmentManager().popBackStack();

        }


    }



    // --------------------------------------- REPLACING MUSCLE GROUPS FRAGMENTS ---------------------------------------
    public void replaceAbdominalFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new AbRoller();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new BicycleCrunches();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new BottomsUpStanding();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new Chrunches();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new ToeToucherCrunches();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new Plank();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new VupAbs();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 8){

            fragment = new BentKneeHitRaise();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 9){

            fragment = new CableTwists();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 10){

            fragment = new DeclineObliqueCrunches();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 11){

            fragment = new CableSeatedCrunches();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    public void replaceBackFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new DeadLift();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new HyperExtension();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new PullUps();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new CloseGripPullDown();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new ReverseGripBentOver();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new PullDownBehindNeck();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new SeatedCableRowing();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    public void replaceBicepsFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new AlternateDumbbellCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new BarbellCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new CableBicepsCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new CloseGripBarbellCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new ConcentrationCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new CrossBodyHammerCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new HammerCurls();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 8){

            fragment = new InclineHammerCurl();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 9){

            fragment = new OverHeadCableCurls();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 10){

            fragment = new HighCableCurls();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    public void replaceChestFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new Butterfly();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new DeclineBenchBarbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new DeclineBenchDumbbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new PlainBenchDumbbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new DumbbellPullOver();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new InclineBenchBarbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new InclineBenchDumbbellFlies();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 8){

            fragment = new PlainBenchBarbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 9){

            fragment = new SingleArmPushUps();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 10){

            fragment = new DeclineBarbellPullOver();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 11){

            fragment = new DeclinePushUps();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    public void replaceLegsFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new WideStanceBarbellSquat();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new BarbellWalking();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new DonkeyCalfRaise();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new DumbbellRearWalking();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new Jogging();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new LegExtension();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new LegPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 8){

            fragment = new SmithMachineSquat();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 9){

            fragment = new SmithMachineCalfRaise();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 10){

            fragment = new SideLegRaise();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    public void replaceShouldersFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new AlternateDeltoidRaise();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new BarbellShoulderPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new DumbbellShoulderPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new Shrugs();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new SingleHandDumbbellFrontRaise();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new SmithMachineShrugs();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new StandingAlternateDumbbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 8){

            fragment = new SmithMachineBackShrugs();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    public void replaceTricepsFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new BenchDips();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new CableOverheadTricepsExtension();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new CloseGripEzBarBenchPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new DumbbellOneArmTricepsExtension();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 5){

            fragment = new LyingTricepsExtensions();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 6){

            fragment = new RopeTricepsPushDown();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 7){

            fragment = new SeatedDumbbellTricepsPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 8){

            fragment = new DeclineEzBarTricepsExtension();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 9){

            fragment = new StandingTricepsKickBack();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 10){

            fragment = new CloseGripDumbbellPress();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 11){

            fragment = new CloseGripDumbbellPushUps();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 12){

            fragment = new TricepsDips();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 13){

            fragment = new StandingBarbellTricepsExtension();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    // --------------------------------------- REPLACING NUTRITION FRAGMENTS ---------------------------------------

    public void replaceDietsFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new HealthiestSummerFruits();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new BurnMoreFat();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new LoseWeight();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new TruthAboutDiets();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    public void replaceFoodFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new DrinkWater10();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new HealthySnacks8();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new ProteinNeverTried();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new WaterInOurBody();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    public void replaceNutrientsFragment(int position){


        Fragment fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (position == 1){

            fragment = new Vegetables();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 2){

            fragment = new ManipulatingHormones();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 3){

            fragment = new CholesterolNeedToKnow();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if (position == 4){

            fragment = new Carbohydrates();
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }


}


