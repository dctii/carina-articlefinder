package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class AttributeConstants {
    private static final Logger LOGGER = LogManager.getLogger(AttributeConstants.class);

    private AttributeConstants() {
    }

    public final static String CLASS = "class";
    public final static String STYLE = "style";
    public final static String VALUE = "value";
    public final static String PLACEHOLDER = "placeholder";
    public final static String TYPE = "type";
    public final static String ROLE = "role";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String FOR = "for";
    public final static String FORM = "form";
    public final static String LIST = "list";
    public final static String ALLOW = "allow";
    public final static String ALLOWFULLSCREEN = ALLOW + "fullscreen";
    public final static String ALLOW_FULL_SCREEN = ALLOWFULLSCREEN;
    public final static String ALLOWPAYMENTREQUEST = ALLOW + "paymentrequest";
    public final static String ALLOW_PAYMENT_REQUEST = ALLOWPAYMENTREQUEST;
    public final static String SANDBOX = "sandbox";
    public final static String STEP = "step";
    public final static String DECODING = "decoding";
    public final static String MAXLENGTH = "maxlength";
    public final static String MAX_LENGTH = MAXLENGTH;
    public final static String MINLENGTH = "minlength";
    public final static String MIN_LENGTH = MINLENGTH;
    public final static String MIN = "min";
    public final static String MAX = "max";
    public final static String ISMAP = "ismap";
    public final static String IS_MAP = ISMAP;
    public final static String USEMAP = "usemap";
    public final static String USE_MAP = USEMAP;
    public final static String LONGDESC = "longdesc";
    public final static String LONG_DESC = LONGDESC;
    public final static String CHECKED = "checked";
    public final static String MULTIPLE = "multiple";
    public final static String PATTERN = "pattern";
    public final static String POPOVER = "popover";
    public final static String POPOVERTARGET = "popovertarget";
    public final static String POPOVER_TARGET = POPOVERTARGET;
    public final static String POPOVERTARGETACTION = "popovertargetaction";
    public final static String POPOVER_TARGET_ACTION = POPOVERTARGETACTION;
    public final static String REQUIRED = "required";
    public final static String SIZE = "size";
    public final static String SIZES = SIZE + "s";
    public final static String FORMTARGET = "formtarget";
    public final static String FORM_TARGET = FORMTARGET;
    public final static String FORMNOVALIDATE = "formnovalidate";
    public final static String FORM_NO_VALIDATE = FORMNOVALIDATE;
    public final static String FORMMETHOD = "formmethod";
    public final static String FORM_METHOD = FORMMETHOD;
    public final static String FORMENCTYPE = "formenctype";
    public final static String FORM_ENC_TYPE = FORMENCTYPE;
    public final static String FORMACTION = "formaction";
    public final static String FORM_ACTION = FORMACTION;
    public final static String DIRNAME = "dirname";
    public final static String DIR_NAME = DIRNAME;
    public final static String CAPTURE = "capture";
    public final static String AUTOCAPITALIZE = "autocapitalize";
    public final static String AUTO_CAPITALIZE = AUTOCAPITALIZE;
    public final static String ACCEPT = "accept";
    public final static String COLS = "cols";
    public final static String ROWS = "rows";
    public final static String WRAP = "wrap";

    public final static String SPELLCHECK = "spellcheck";
    public final static String READONLY = "readonly";
    public final static String READ_ONLY = READONLY;
    public final static String DISABLED = "disabled";
    public final static String AUTOFOCUS = "autofocus";
    public final static String AUTO_FOCUS = AUTOFOCUS;
    public final static String AUTOCOMPLETE = "autocomplete";
    public final static String AUTO_COMPLETE = AUTOCOMPLETE;
    public final static String LOADING = "loading";
    public final static String REFERRERPOLICY = "referrerpolicy";
    public final static String FETCHPRIORITY = "fetchpriority";
    public final static String FETCH_PRIORITY = FETCHPRIORITY;
    public final static String WIDTH = "width";
    public final static String HEIGHT = "height";
    public final static String METHOD = "method";
    public final static String TITLE = "title";
    public final static String SRC = "src";
    public final static String SRCSET = "srcset";
    public final static String ALT = "alt";
    public final static String HREF = "href";
    public final static String CROSSORIGIN = "crossorigin";

    public final static String TABINDEX = "tabindex";
    public final static String TAB_INDEX = TABINDEX;
    public final static String TARGET = "target";
    public final static String RELATIONSHIP = "rel";
    public final static String REL = RELATIONSHIP;
    public final static String INCREMENTAL = "incremental";
    public final static String WEBKITDIRECTORY = "webkitdirectory";
    public final static String WEB_KIT_DIRECTORY = WEBKITDIRECTORY;

    public final static String ACCESSKEY = "accesskey";
    public final static String ACCESS_KEY = ACCESSKEY;
    public final static String CONTENTEDITABLE = "contenteditable";
    public final static String CONTENT_EDITABLE = CONTENTEDITABLE;
    public final static String CONTEXTMENU = "contextmenu";
    public final static String CONTEXT_MENU = CONTEXTMENU;
    public final static String DIR = "dir";
    public final static String DRAGGABLE = "draggable";
    public final static String ENTERKEYHINT = "enterkeyhint";
    public final static String ENTER_KEY_HINT = ENTERKEYHINT;
    public final static String EXPORTPARTS = "exportparts";
    public final static String EXPORT_PARTS = EXPORTPARTS;
    public final static String HIDDEN = "hidden";
    public final static String INERT = "inert";
    public final static String INPUTMODE = "inputmode";
    public final static String INPUT_MODE = INPUTMODE;
    public final static String IS = "is";
    public final static String ITEMID = "itemid";
    public final static String ITEM_ID = ITEMID;
    public final static String ITEMPROP = "itemprop";
    public final static String ITEM_PROP = ITEMPROP;
    public final static String ITEMREF = "itemref";
    public final static String ITEM_REF = ITEMREF;
    public final static String ITEMSCOPE = "itemscope";
    public final static String ITEM_SCOPE = ITEMSCOPE;
    public final static String ITEMTYPE = "itemtype";
    public final static String ITEM_TYPE = ITEMSCOPE;
    public final static String LANG = "lang";
    public final static String NONCE = "nonce";
    public final static String PART = "part";
    public final static String SLOT = "slot";
    public final static String TRANSLATE = "translate";
    public final static String VIRTUALKEYBOARDPOLICY = "virtualkeyboardpolicy";
    public final static String VIRTUAL_KEYBOARD_POLICY = VIRTUALKEYBOARDPOLICY;


    public final static String DATA_PREFIX = "data-";
    public final static String DATA_TESTID = DATA_PREFIX + "testid";
    public final static String DATA_NAVID = DATA_PREFIX + "navid";
    public final static String DATA_PROVIDER = DATA_PREFIX + "provider";
    public final static String ARIA_PREFIX = "aria-";
    /*
        ARIA Non-global Widget Attributes
     */
    public final static String ARIA_AUTOCOMPLETE = ARIA_PREFIX + "autocomplete";
    public final static String ARIA_CHECKED = ARIA_PREFIX + "checked";
    public final static String ARIA_EXPANDED = ARIA_PREFIX + "expanded";
    public final static String ARIA_LEVEL = ARIA_PREFIX + "level";
    public final static String ARIA_MODAL = ARIA_PREFIX + "modal";
    public final static String ARIA_MULTILINE = ARIA_PREFIX + "multiline";
    public final static String ARIA_MULTISELECTABLE = ARIA_PREFIX + "multiselectable";
    public final static String ARIA_ORIENTATION = ARIA_PREFIX + "orientation";
    public final static String ARIA_PLACEHOLDER = ARIA_PREFIX + "placeholder";
    public final static String ARIA_PRESSED = ARIA_PREFIX + "pressed";
    public final static String ARIA_READONLY = ARIA_PREFIX + "readonly";
    public final static String ARIA_REQUIRED = ARIA_PREFIX + "required";
    public final static String ARIA_SELECTED = ARIA_PREFIX + "selected";
    public final static String ARIA_SORT = ARIA_PREFIX + "sort";
    public final static String ARIA_VALUEMAX = ARIA_PREFIX + "valuemax";
    public final static String ARIA_VALUEMIN = ARIA_PREFIX + "valuemin";
    public final static String ARIA_VALUENOW = ARIA_PREFIX + "valuenow";
    public final static String ARIA_VALUETEXT = ARIA_PREFIX + "valuetext";


    /*
        ARIA Non-global Relationship attributes
     */

    public final static String ARIA_ACTIVEDESCENDANT = ARIA_PREFIX + "activedescendant";
    public final static String ARIA_COLCOUNT = ARIA_PREFIX + "colcount";
    public final static String ARIA_COLINDEX = ARIA_PREFIX + "colindex";
    public final static String ARIA_COLSPAN = ARIA_PREFIX + "colspan";
    public final static String ARIA_POSINSET = ARIA_PREFIX + "posinset";
    public final static String ARIA_ROWCOUNT = ARIA_PREFIX + "rowcount";
    public final static String ARIA_ROWINDEX = ARIA_PREFIX + "rowindex";
    public final static String ARIA_ROWSPAN = ARIA_PREFIX + "rowspan";
    public final static String ARIA_SETSIZE = ARIA_PREFIX + "setsize";

    /*
        ARIA global attributes
     */
    public final static String ARIA_ATOMIC = ARIA_PREFIX + "atomic";
    public final static String ARIA_BUSY = ARIA_PREFIX + "busy";
    public final static String ARIA_CONTROLS = ARIA_PREFIX + "controls";
    public final static String ARIA_CURRENT = ARIA_PREFIX + "current";
    public final static String ARIA_DESCRIBEDBY = ARIA_PREFIX + "describedby";
    public final static String ARIA_DESCRIPTION = ARIA_PREFIX + "description";
    public final static String ARIA_DETAILS = ARIA_PREFIX + "details";
    public final static String ARIA_DISABLED = ARIA_PREFIX + "disabled";
    public final static String ARIA_DROPEFFECT = ARIA_PREFIX + "dropeffect";
    public final static String ARIA_ERRORMESSAGE = ARIA_PREFIX + "errormessage";
    public final static String ARIA_FLOWTO = ARIA_PREFIX + "flowto";
    public final static String ARIA_GRABBED = ARIA_PREFIX + "grabbed";
    public final static String ARIA_HASPOPUP = ARIA_PREFIX + "haspopup";
    public final static String ARIA_HIDDEN = ARIA_PREFIX + "hidden";
    public final static String ARIA_INVALID = ARIA_PREFIX + "invalid";
    public final static String ARIA_KEYSHORTCUTS = ARIA_PREFIX + "keyshortcuts";
    public final static String ARIA_LABEL = ARIA_PREFIX + "label";
    public final static String ARIA_LABELLEDBY = ARIA_PREFIX + "labelledby";
    public final static String ARIA_LIVE = ARIA_PREFIX + "live";
    public final static String ARIA_OWNS = ARIA_PREFIX + "owns";
    public final static String ARIA_RELEVANT = ARIA_PREFIX + "relevant";
    public final static String ARIA_ROLEDESCRIPTION = ARIA_PREFIX + "roledescription";


}
