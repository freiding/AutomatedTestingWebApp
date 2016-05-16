package core.data;

/**
 * Created by bogat on 5/12/2016.
 */
public class XpathList {

    public static final String START_PAGE_USERNAME_LABEL = ".//*[@id='gb']/div[1]/div[1]/div[1]/div/span";
    public static final String START_PAGE_POST_TEXT_AREA = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[1]/div/div/div[1]/div[2]";
    public static final String START_PAGE_POST_MESSAGE_TEXT_FIELD = ".//div[@guidedhelpid='sharebox_editor']/div[2]/div[2]";
    public static final String START_PAGE_DIALOG_POST_ADD_BUTTON = ".//div[@guidedhelpid='shareboxcontrols']/table/tbody/tr/td[1]/div[1]";
    public static final String START_PAGE_POST_MENU_ITEMS= ".//div[@class='YH WD d-r']//div[@role='menuitem']";
    public static final String START_PAGE_LASTPOST_TEXT_LABEL = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div[2]";
    public static final String START_PAGE_LASTPOST_AUTHOR_LABEL = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div/header/h3/a";
    public static final String START_PAGE_LASTPOST_MENU_BUTTON = ".//*[@id='contentPane']/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/span";
    public static final String START_PAGE_CONFIRM_DIALOG_DELETE_BUTTON = ".//div[@class='G-q-ea']/button[1]";

    public static final String SIGN_IN_PAGE_EMAIL_TEXTFIELD = ".//*[@id='Email']";
    public static final String SIGN_IN_PAGE_PASSWORD_TEXTFIELD = ".//*[@id='Passwd']";
    public static final String SIGN_IN_PAGE_NEXT_BUTTON = ".//*[@id='next']";
    public static final String SIGN_IN_PAGE_SIGNIN_BUTTON = ".//*[@id='signIn']";

    public static final String SEARCH_PAGE_SEARCH_TEXTFIELD = ".//*[@id='gbqfq']";
    public static final String SEARCH_PAGE_SEARCH_BUTTON = ".//*[@id='gbqfb']";
    public static final String SEARCH_PAGE_SEARCH_TITLE = ".//div[@class='Wzc ACd']";

    public static final String EVENTS_PAGE_CREATE_EVENT_BUTTON = ".//div[@role='main']/div/div/div[1]/div/div[1]";
    public static final String EVENTS_PAGE_DIALOG_EVENT_TITLE_TEXTFIELD = ".//div[@class='zC rOa']/input";
    public static final String EVENTS_PAGE_DIALOG_EVENT_DATE_TEXTFIELD = ".//input[@class='o-E-N TJ Pma']";
    public static final String EVENTS_PAGE_DIALOG_EVENT_TIME_TEXTFIELD = ".//input[@class='o-E-N TJ dEa']";
    public static final String EVENTS_PAGE_DIALOG_EVENT_LOCATION_TEXTFIELD = ".//input[@class='o-E-N Eaa NEa ka-N-ka']";
    public static final String EVENTS_PAGE_DIALOG_EVENT_DESCRIPTION_TEXTFIELD = ".//div[@class='o-E-N Lea']/div";
    public static final String EVENTS_PAGE_DIALOG_EVENT_FOR_WHOM_TEXTFIELD = ".//input[@class='g-h-f-N-N']";
    public static final String EVENTS_PAGE_DIALOG_EVENT_FOR_FOLLOWINGS = ".//div[@role='listbox']/div[1]/div/span[2]";
    public static final String EVENTS_PAGE_DIALOG_EVENT_INVITE_BUTTON = ".//div[@guidedhelpid='sharebutton']";

    public static final String EVENT_PAGE_EVENT_TITLE = ".//*[@id='contentPane']/div/div/div/div[3]/div[2]/div[1]/div[2]";
    public static final String EVENT_PAGE_EVENT_AUTHOR = ".//*[@id='contentPane']/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/a";
    public static final String EVENT_PAGE_EVENT_MENU_BUTTON = ".//*[@id='contentPane']/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]";
    public static final String EVENT_PAGE_EVENT_MENU_ITEMS = ".//div[@role='menu']//div[@role='menuitem']";
    public static final String EVENT_PAGE_EVENT_DIALOG_DELETE_BUTTON = ".//button[@name='ok']";

    public static final String COLLECTIONS_PAGE_COLLECTION_CREATE_BUTTON = ".//div[@class='Vw0rI EOIHwb']/div[3]/span";
    public static final String COLLECTIONS_PAGE_COLLECTION_DIALOG_TITLE_TEXTFIELD = ".//div[@class='G-q-B']/div/div[1]/input";
    public static final String COLLECTIONS_PAGE_COLLECTION_DIALOG_DESCRIPTION_TEXTFIELD = ".//div[@class='G-q-B']/div/div[2]/input";
    public static final String COLLECTIONS_PAGE_COLLECTION_DIALOG_CREATE_BUTTON = ".//div[@class='G-q-ea']/div[2]";

    public static final String COLLECTION_PAGE_COLLECTION_TITLE_LABEL = ".//span[@itemprop='name']";
    public static final String COLLECTION_PAGE_COLLECTION_AUTHOR_LABEL = ".//a[@rel='author']";
    public static final String COLLECTION_PAGE_COLLECTION_DESCRIPTION_LABEL = ".//*[@id='contentPane']/div/div[3]/div[1]/div/div[2]/div/div[1]/div[2]/div";
    public static final String COLLECTION_PAGE_COLLECTION_ACTIONS_MENU_BUTTON = ".//span[@class='fld']";
    public static final String COLLECTION_PAGE_COLLECTION_DELETE_DIALOG_CONFIRM_CHECKBOX = ".//div[@role='checkbox']";
    public static final String COLLECTION_PAGE_COLLECTION_DELETE_DIALOG_DELETE_BUTTON = ".//div[@role='dialog']/div[3]/div[2]";
    public static final String COLLECTION_PAGE_COLLECTION_POSTS = ".//div[@class='ki ve']";
    public static final String COLLECTION_PAGE_COLLECTION_POST_AUTHOR_LABEL = ".//a[@class='ob tv Ub Hf']";
    public static final String COLLECTION_PAGE_COLLECTION_POST_TEXT_LABEL = ".//div[@class='Ct']";
    public static final String COLLECTION_PAGE_COLLECTION_POST_TEXTAREA = ".//div[@guidedhelpid='sharebox_textarea']";
    public static final String COLLECTION_PAGE_COLLECTION_POST_DIALOG_TEXTAREA = ".//div[@class='URaP8 Kf Pf b-K b-K-Xb']/div[2]";
    public static final String COLLECTION_PAGE_COLLECTION_POST_DIALOG_SHARED_BUTTON = ".//div[@guidedhelpid='shareboxcontrols']/table/tbody/tr/td/div[1]";

    public static final String COMMUNITIES_PAGE_RECOMENDED_COMUNITIES = ".//div[@role='article']";
    public static final String COMMUNITIES_PAGE_RECOMENDED_COMUNITY_TITLE = "//div[@class='hDc']";
    public static final String COMMUNITIES_PAGE_RECOMENDED_COMUNITY_JOIN_BUTTON = "//span[@guidedhelpid='community_join_button']";
    public static final String COMMUNITIES_PAGE_JOINED_COMMUNITIES = ".//div[@class='k9c mke Pic I8c JUKJAb']";
    public static final String COMMUNITIES_PAGE_JOINED_COMMUNITY_TITLE = "//a[@class='d-s ob w1d ATc']";
    public static final String COMMUNITIES_PAGE_SEARCH_COMMUNITY_TEXTBOX = ".//div[@class='XYd oTc']/input";

    public static final String COMMUNITIY_PAGE_MENU_SETTINGS_BUTTON = ".//div[@class='d-y-r-c-ha fjzDZe']/div";
    public static final String COMMUNITIY_PAGE_MENU_SETTINGS_ITEMS = "//div[@class='d-r d-r-ih']/div";
    public static final String COMMUNITIY_PAGE_CONFIRM_LEAVE_FRAME_LEAVE_BUTTON = ".//div[@class='G-q-ea']/button[2]";

    public static final String CIRCLES_PAGE_CIRCLES = ".//div[@class='XCd']";
    public static final String CIRCLES_PAGE_CIRCLES_TITLE = ".//div[@class='XCd']//span";
    public static final String CIRCLES_PAGE_CIRCLE_CONTACTS_COUNTER = ".//div[@class='uBc']";
    public static final String CIRCLES_PAGE_CIRCLE_DELETE_BUTTON = ".//div[@class='Rna d-k-l oBb Rna']";
    public static final String CIRCLES_PAGE_NEW_CIRCLE_BUTTON = ".//div[@guidedhelpid='newcirclecircle']";
    public static final String CIRCLES_PAGE_FRAME_CREATE_CIRCLE = ".//div[@class='G-q o-LX-XUa oKb']";
    public static final String CIRCLES_PAGE_FRAME_CREATE_CIRCLE_TITLE_TEXTBOX = "//input[@class='t-xl-vc-oa t-xl-vc qKb']";
    public static final String CIRCLES_PAGE_FRAME_CREATE_CIRCLE_CREATE_BUTTON  = "//button[@name='save']";
    public static final String CIRCLES_PAGE_FRAME_CONFIRM_DELETE_CIRCLE = ".//div[@class='G-q']";
    public static final String CIRCLES_PAGE_FRAME_CONFIRM_DELETE_CIRCLE_DELETE_BUTTON = ".//button[@name='ok']";
    public static final String CIRCLES_PAGE_ADD_CONTACT_BUTTON = ".//div[@guidedhelpid='peopleeditor_addpersontile']/div[2]";
    public static final String CIRCLES_PAGE_ALLERT_DIALOG_INPUT = ".//input[@class='fH r6a']";
    public static final String CIRCLES_PAGE_ALLERT_DIALOG_CIRCLES_LIST = ".//div[@guidedhelpid='circlelist']/div[1]/div"; //span[@role='checkbox']
    public static final String CIRCLES_PAGE_ALLERT_DIALOG_SAVE_BUTTON = ".//div[@class='HQ m6a']/div[1]";
    public static final String CIRCLES_PAGE_CONTACT = ".//div[@role='link']";
    public static final String CIRCLES_PAGE_CONTACT_DELETE_BUTTON = ".//div[@class='bxa snb-u']";

    public static final String MENU_ITEMS = ".//div[@role='menu']//div[@role='menuitem']";
}

