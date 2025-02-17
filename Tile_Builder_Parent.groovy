/**
*  Tile Builder Parent App
*  Version: See ChangeLog
*  Download: See importUrl in definition
*  Description: Used in conjunction with child apps to generate tabular reports on device data and publishes them to a dashboard.
*
*  Copyright 2022 Gary J. Milne  
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.

*  License:
*  You are free to use this software in an un-modified form. Software cannot be modified or redistributed.
*  You may use the code for educational purposes or for use within other applications as long as they are unrelated to the 
*  production of tabular data in HTML form, unless you have the prior consent of the author.
*  You are granted a license to use Tile Builder in its standard configuration without limits.
*  Use of Tile Builder in it's Advanced requires a license key that must be issued to you by the original developer. TileBuilderApp@gmail.com
*
*  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
*  implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 

*  Authors Notes:
*  For more information on Activity Monitor & Attribute Monitor check out these resources.
*  Original posting on Hubitat Community forum: TBD
*  Tile Builder Documentation: https://github.com/GaryMilne/Hubitat-TileBuilder/blob/main/Tile%20Builder%20Help.pdf
*
*  Tile Builder Parent App - ChangeLog
*  Version 1.0.3 - Internal Only
*  Version 1.0.4 - Cleaned up Styles. Cleaned up message text. Small bug fixes.
*  Version 1.0.5 - Added styles.
*  Version 1.0.6 - Fixed bug in loading any style that had an = sign embedded in the values side of the key\value pair.
*  Version 1.0.7 - Changes to licensing text and links.
*  Version 1.0.8 - Added Tile Deletion button and logic. Cleaned up some verbage.
*  Version 1.0.9 - Cleaned up styles, some adds, some settings, some deletes.
*  Version 1.1.0 - Add additional examples to override helper.
*  Version 1.1.1 - Cleanup of some of the in-line help information. 
*  Version 1.1.2 - Added licensing routines. 
*  Version 1.2.0 - Limited public release. Version change to synchronize with other modules and Help. 
*  Version 1.2.2 - Rework of setup screen based on feedback from @sburke781. Simplifies, reduces screen clutter and add a setup "Wizard".
*  Version 1.2.3 - Adds a footer to the main screen containing versioning information.
*  Version 1.2.4 - Split Overrides Helper examples into multiple categories for easier navigation. Add new examples.
*  Version 1.2.6 - Round up version to match child Apps.
*  Version 1.2.7 - Fixed a few errors in styles.
*  Version 1.2.8 - Cleaned up some built-in style values.
*
*  Gary Milne - May 14th, 2023
*
**/
import groovy.transform.Field
@Field static final Version = "<b>Tile Builder Parent v1.2.8 (5/14/23)</b>"

//These are the data for the pickers used on the child forms.
def elementSize() { return ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'] }
def textScale() { return ['50', '55', '60', '65', '70', '75', '80', '85', '90', '95', '100', '105', '110', '115', '120', '125', '130', '135', '140', '145', '150', '175', '200', '250', '300', '350', '400', '450', '500'] }
def fontFamily() { return ['Arial', 'Arial Sans Serif', 'Arial Black', 'Brush Script MT', 'Comic Sans MS', 'Courier New', 'Garamond', 'Georgia', 'Hubitat', 'Lucida', 'Monospace', 'Palatino', 'Roboto', 'Tahoma', 'Times New Roman', 'Trebuchet MS', 'Verdana'] }
//def fontFamily(){ return["Arial","Arial Sans Serif","Arial Black","Brush Script MT","Comic Sans MS","Courier New","Garamond","Georgia","Hubitat","Lucida","Material Symbols Outlined","Monospace","Palatino","Roboto","Tahoma","Times New Roman","Trebuchet MS","Verdana"] }
def borderStyle() { return ['Dashed', 'Dotted', 'Double', 'Groove', 'Hidden', 'Inset', 'Outset', 'Ridge', 'Solid'] }
def tableStyle() { return ['Collapse', 'Seperate'] }
def textAlignment() { return ['Left', 'Center', 'Right', 'Justify'] }
def tableSize() { return ['Auto', '50', '55', '60', '65', '70', '75', '80', '85', '90', '95', '100'] }
def opacity() { return ['1', '0.9', '0.8', '0.7', '0.6', '0.5', '0.4', '0.3', '0.2', '0.1', '0'] }
def inactivityTime() { return [0:'0 hours', 1:'1 hour', 2:'2 hours', 4:'4 Hours', 8:'8 hours', 12:'12 hours', 24:'1 day', 48:'2 days', 72:'3 days', 168:'1 week', 336:'2 weeks', 730:'1 month', 2190:'3 months', 4380:'6 months', 8760:'1 year'] }
def deviceLimit() { return [0:'0 devices', 1:'1 device', 2:'2 devices', 3:'3 devices', 4:'4 devices', 5:'5 devices', 6:'6 devices', 7:'7 devices', 8:'8 devices', 9:'9 devices', 10:'10 devices', 11:'11 device', 12:'12 devices', 13:'13 devices', 14:'14 devices', 15:'15 devices', 16:'16 devices', 17:'17 devices', 18:'18 devices', 19:'19 devices', 20:'20 devices', 21:'21 device', 22:'22 devices', 23:'23 devices', 24:'24 devices', 25:'25 devices', 26:'26 devices', 27:'27 devices', 28:'28 devices', 29:'29 devices', 30:'30 devices'] }
def truncateLength() { return [99:'No truncation.', 98:'First Space', 97:'Second Space', 96:'Third Space', 10:'10 characters.', 12:'12 characters.', 15:'15 characters.', 18:'18 characters.', 20:'20 characters.', 22:'22 characters.', 25:'25 characters.', 30:'30 characters.'] }
def refreshInterval() { return [0:'Never', 1:'1 minute', 2:'2 minutes', 5:'5 minutes', 10:'10 minutes', 15:'15 minutes', 30:'30 minutes', 60:'1 hour', 120:'2 hours', 240:'4 hours', 480:'8 hours', 720:'12 hours', 1440:'24 hours'] }
def pixels() { return ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '-1', '-2', '-3', '-4', '-5', '-6', '-7', '-8', '-9', '-10', '-11', '-12', '-13', '-14', '-15', '-16', '-17', '-18', '-19', '-20'] }
def borderRadius() { return ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30'] }
def baseFontSize() { return ['10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '22', '24', '26', '28', '30'] }
def tilePreviewList() { return [1:'1 x 1', 2:'1 x 2', 3:'1 x 3', 4:'1 x 4', 5:'2 x 1', 6:'2 x 2', 7:'2 x 3', 8:'2 x 4'] }
def storageDevices() { return ['Tile Builder Storage Device 1', 'Tile Builder Storage Device 2', 'Tile Builder Storage Device 3'] }
def allTileList() { return [1:'tile1', 2:'tile2', 3:'tile3', 4:'tile4', 5:'tile5', 6:'tile6', 7:'tile7', 8:'tile8', 9:'tile9', 10:'tile10', 11:'tile11', 12:'tile12', 13:'tile13', 14:'tile14', 15:'tile15', 16:'tile16', 17:'tile17', 18:'tile18', 19:'tile19', 20:'tile20', 21:'tile21', 22:'tile22', 23:'tile23', 24:'tile24', 25:'tile25'] }
def filterList() { return [0:'No Filter', 1:'String ==', 2:'String !=', 3:'Numeric ==', 4:'Numeric <=', 5:'Numeric >='] }
def overrideCategory() { return ['Animation', 'Field Replacement', 'Text', 'Border', 'Background', 'Misc', 'Classes', 'Margin & Padding', 'Transform'] }

definition(
    name: 'Tile Builder',
    namespace: 'garyjmilne',
    author: 'Gary Milne',
    description: 'This is the Tile Builder Parent App',
    category: 'Dashboards',
	importUrl: "https://raw.githubusercontent.com/GaryMilne/Hubitat-TileBuilder/main/Tile_Builder_Parent.groovy",
    iconUrl: '',
    iconX2Url: '',
    iconX3Url: '',
    singleThreaded: true,
    installOnOpen: true
    )
	
preferences {
    page name: 'mainPage', title: '', install: true, uninstall: true // ,submitOnChange: true
}

def mainPage() {
    if (state.initialized == null ) initialize()
    //initialize()

    dynamicPage(name: "mainPage") {
        //See if the user has changed the selected storage device
        isSelectedDeviceChanged()

        //Refresh the UI - neccessary for controls located on the same page.
        refreshUI()

        //This is all a single section as section breaks have been commented out. This uses less screen space.
        section { 
            paragraph "<div style='text-align:center;color: #c61010; font-size:30px;text-shadow: 0 0 5px #FFF, 0 0 10px #FFF, 0 0 15px #FFF, 0 0 20px #49ff18, 0 0 30px #49FF18, 0 0 40px #49FF18, 0 0 55px #49FF18, 0 0 75px #ffffff;;'> Tile Builder 🎨</div>"
            //Intro
            if (state.showIntro == true || state.setupState == 1) {
                input(name: 'btnShowIntro', type: 'button', title: 'Introduction ▼', backgroundColor: 'navy', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
                
                part1 = "<b>Tile Builder</b> allows you to create custom tiles with a broad range of information that can be published to a <b>Hubitat Dashboard</b> using a native application. "
                part2 = "<b>Tile Builder</b> can eliminate the hassle of maintaining a seperate system in order to get an attractive dashboard. A sample tile generated with Tile Builder Advanced is shown below.<br>"
                if (state.setupState != 99) titleise2(red("<b>First time setup!</b>"))
                paragraph(part1 + part2)
                
                myString = "You are installing <b>Tile Builder Standard which is free</b> and provides a highly functional addition to the basic Hubitat Dashboard capabilities.<br>"
                myString += "If you wish to upgrade to <b>Tile Builder Advanced</b> you can do so after setup is complete by visiting the Licensing section."
                paragraph myString
                
                //Get the sample table
                myHTML = getSample()
                paragraph '<iframe srcdoc=' + '"' + myHTML + '"' + ' width="170" height="160" style="border:solid;color:red" scrolling="no"></iframe>'
                
                if (state.setupState != 99) myText = "  Use the <b>Next</b> button to move through the sections for initial setup."
                else myText = "<b>Click on the section headers to navigate to a section.</b>"
                paragraph(myText)
                
                //Only show button during the setup process
                if (state.setupState != 99) {
                    input(name: 'btnNext1', type: 'button', title: 'Next ▶', backgroundColor: 'teal', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
                }
            }
            else {
                input(name: 'btnShowIntro', type: 'button', title: 'Introduction ▶', backgroundColor: 'DodgerBlue', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
            }
            paragraph line(2)
            //End of Intro
            
            
            //Licensing
            if (state.setupState == 99) {
                if (state.showLicense == true) {
                    input(name: 'btnShowLicense', type: 'button', title: 'Licensing ▼', backgroundColor: 'navy', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true, newLineAfter: false)  //▼ ◀ ▶ ▲
                    myString = "<b>Tile Builder Standard is free</b> and provides a highly functional addition to the basic Hubitat Dashboard capabilities.<br>"
                    myString += "<b>Tile Builder Advanced</b> adds Filters, Highlights, Styles and a range of powerful customizations options. "
			        myString += "Click <a href='https://github.com/GaryMilne/Hubitat-TileBuilder/blob/main/Tile%20Builder%20Help.pdf'>here</a> for more information.</br></br>"
            
                    myString = myString + "To purchase the license for <b>Tile Builder Advanced</b> you must do the following:<br>"
                    myString += "<b>1)</b> Donate at least <b>\$5</b> to ongoing development via PayPal using this <a href='https://www.paypal.com/donate/?business=YEAFRPFHJCTFA&no_recurring=1&item_name=A+donation+of+\$5+or+more+grants+you+license+to+Tile+Builder+Advanced.+Please+leave+your+Hubitat+Community+ID.&currency_code=USD'>link.</a></br>"			
                    myString += "<b>2)</b> Forward the paypal eMail receipt along with your ID (<b>" + getID() + "</b>) to <b>TileBuilderApp@gmail.com</b>. Please include your Hubitat community ID for future notifications.<br>"
                    myString += "<b>3)</b> Wait for license key eMail notification (usually within 24 hours).<br>"
                    myString += "<b>4)</b> Apply license key using the input box below.<br>"
                    myString += "<b>Please respect the time and effort it took to create this application and comply with the terms of the license.</b>"
                    paragraph note('', myString)
            
                    if (state.isAdvancedLicense == false ){
                        input (name: "licenseKey", title: "<b>Enter Advanced License Key</b>", type: "string", submitOnChange:true, width:3, defaultValue: "?")
                        input (name: 'activateLicense', type: 'button', title: 'Activate Advanced License', backgroundColor: 'orange', textColor: 'black', submitOnChange: true, width: 2)
                        myString = '<b>Activation State: ' + red(state.activationState) + '</b><br>'
                        myString = myString + 'You are running ' + dodgerBlue('<b><u>Tile Builder Standard</u></b>')
                        paragraph myString
                    }
                    else {
                        myString = '<b>Activation State: ' + green(state.activationState) + '</b><br>'
                        myString = myString + 'You are running ' + green('<b><u>Tile Builder Advanced</u></b>')
                        paragraph myString
                    }
                }
            else {
                input(name: 'btnShowLicense', type: 'button', title: 'Licensing ▶', backgroundColor: 'DodgerBlue', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
                }
            paragraph line(2)
            }
            //End of Licensing
            
            //Device
            if (state.showDevice == true ) {
                input(name: 'btnShowDevice', type: 'button', title: 'Storage Device ▼', backgroundColor: 'navy', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true)  //▼ ◀ ▶ ▲
                paragraph "<b>Tile Builder</b> stores generated tiles on a special purpose <u>Tile Builder Storage Device</u>. You must <b>create a device and attach</b> to it using the controls below.<br>"                 
                paragraph note('Note: ', "Each instance of <b>Tile Builder</b> must have it's own unique storage device.")
                    
                if (state.isStorageConnected == false ) {
                    paragraph red('❌ - A Tile Builder Storage Device is not connected.')
                    myString = "You do not have a 'Tile Builder Storage Device' connected. Click the button below to create\\connect one. <br>"
                    myString += "<b>Important: </b>If you remove the <b>Tile Builder</b> App the Tile Builder Storage Device will become orphaned and unusable. <br>"
                    myString += "<b>Note: </b>It is possible to install multiple instances of <b>Tile Builder</b>. In such a scenario each instance should be connected to a unique Tile Builder Storage Device."
                    
                    input(name: 'selectedDevice', type: 'enum', title: bold('Select a Tile Builder Storage Device'), options: storageDevices(), required: false, defaultValue: 'Tile Builder Storage Device 1', submitOnChange: true, width: 3, newLineAfter:true)
                    input(name: 'createDevice', type: 'button', title: 'Create Device', backgroundColor: 'MediumSeaGreen', textColor: 'white', submitOnChange: true, width: 2)
                    //paragraph ("isStorageConnected: $state.isStorageConnected")
                    
                    if (state.isStorageConnected == false) input(name: 'connectDevice', type: 'button', title: 'Connect Device', backgroundColor: 'Orange', textColor: 'white', submitOnChange: true, width: 2)
                    else input(name: 'doNothing', type: 'button', title: 'Connect Device', backgroundColor: 'MediumSeaGreen', textColor: 'white', submitOnChange: true, width: 2)
                            
                    input(name: 'deleteDevice', type: 'button', title: 'Delete Device', backgroundColor: 'Maroon', textColor: 'yellow', submitOnChange: true, width: 2, newLineAfter: true)
                    if (state.hasMessage != null && state.hasMessage != '' ) {
                        if (state.hasMessage.contains("Error")) paragraph note('', red(state.hasMessage))
                        else paragraph note('', green(state.hasMessage))
                    }
                }
                else {
                    paragraph green('✅ - ' + state.myStorageDevice + ' is connected.')
                    paragraph note('', 'You have successfully connected to a Tile Builder Storage Device on your system. You can now create and publish tiles.')
                    input(name: 'disconnectDevice', type: 'button', title: 'Disconnect Device', backgroundColor: 'orange', textColor: 'black', submitOnChange: true, width: 2, newLineAfter: true)
                    }
                //Only show button during the setup process
                if (state.setupState != 99)
                    input(name: 'btnNext2', type: 'button', title: 'Next ▶', backgroundColor: 'teal', textColor: 'white', submitOnChange: true, width: 2, newLine: true)  //▼ ◀ ▶ ▲
                }
            else input(name: 'btnShowDevice', type: 'button', title: 'Storage Device ▶', backgroundColor: 'DodgerBlue', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
            paragraph line(2)
            //End of Device
                    
            //Setup Complete
            if (state.setupState == 3){
                paragraph titleise2(green('The required steps for setup are now complete!<br>'))
                paragraph 'Click <b>Finish Setup</b> to proceed to creating your first tile!'
                paragraph note("Note: ", "From now on you can click on the section headers to navigate the configuration options.")
                input(name: 'btnNext3', type: 'button', title: 'Finish Setup ▶', backgroundColor: 'teal', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
                paragraph line(2)
                }
            //End of Setup
            
            //Create Tiles
            if (state.setupState == 99) {
                if (state.showCreateEdit == true) {
                    //if (true ){
                    input(name: 'btnShowCreateEdit', type: 'button', title: 'Create\\Edit Tiles ▼', backgroundColor: 'navy', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true, newLineAfter: false)  //▼ ◀ ▶ ▲
                    myString = '<b>Tile Builder</b> has two types of tile:<br>'
                    myString += '<b>1) Activity Monitor:</b> Tiles monitor a group of devices for activity\\inactivity using the <b>lastActivityAt</b> attribute. These tiles are refreshed at routine intervals.<br>'
                    myString += '<b>2) Attribute Monitor:</b> Tiles are event driven and aggregate multiple devices\\single attribute into a single tile. For example, all room temps on a single tile.<br>'
                    paragraph note('', myString)
                    app(name: 'TBPA', appName: 'Tile Builder - Activity Monitor', namespace: 'garyjmilne', title: 'Add New Activity Monitor', multiple: true)
                    app(name: 'TBPA', appName: 'Tile Builder - Attribute Monitor', namespace: 'garyjmilne', title: 'Add New Attribute Monitor', multiple: true)
                    }
                else {
                    input(name: 'btnShowCreateEdit', type: 'button', title: 'Create\\Edit Tiles ▶', backgroundColor: 'DodgerBlue', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true, newLineAfter: false)  //▼ ◀ ▶ ▲
                }
                paragraph line(2)
            }
            //End of Create Tiles
        
            //Manage Tiles 
            if (state.setupState == 99) {
                if (state.showManage == true ) {
                    input(name: 'btnShowManage', type: 'button', title: 'Manage Tiles ▼', backgroundColor: 'navy', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true, newLineAfter: false)  //▼ ◀ ▶ ▲
                    myString = 'Here you can view information about the tiles on this storage device, which tiles are in use, the last time those tiles were updated and delete obsolete tiles.<br>'
                    myString += 'In the <b>Tile Builder Storage Device</b> you can preview also the tiles, add descriptions and delete tiles as neccessary.'
                    paragraph note('Note: ', myString)
                    input name: 'tilesInUse', type: 'enum', title: bold('List Tiles in Use'), options: getTileList(), required: false, defaultValue: 'Tile List', submitOnChange: false, width: 4, newLineAfter:false
                    input name: 'tilesInUseByActivity', type: 'enum', title: bold('List Tiles in Use By Activity'), options: getTileListByActivity(), required: false, defaultValue: 'Tile List By Activity', submitOnChange: true, width: 4, newLineAfter:true
		    		input(name: 'deleteTile', type: 'button', title: '↑ Delete ↑ Selected ↑ Tile ↑', backgroundColor: 'Maroon', textColor: 'yellow', submitOnChange: true, width: 2)
			    	paragraph note('Note: ', 'Deleting a tile does not delete the <b>Tile Builder</b> child app that generates the tile. Delete the child app first and then delete the tile.')
                }
                
            else {
                input(name: 'btnShowManage', type: 'button', title: 'Manage Tiles ▶', backgroundColor: 'DodgerBlue', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true, newLineAfter: false)  //▼ ◀ ▶ ▲
                }
            paragraph line(2)
            }
            //End of Manage  
       
            //More
            if (state.setupState == 99) {
                if (state.showMore == true) {
                    input(name: 'btnShowMore', type: 'button', title: 'More ▼', backgroundColor: 'navy', textColor: 'white', submitOnChange: true, width: 2, newLineBefore: true, newLineAfter: true)  //▼ ◀ ▶ ▲
                    label title: bold('Enter a name for this Tile Builder parent instance (optional)'), required: false, width: 4
                    input (name: "isLogInfo",  type: "bool", title: "<b>Enable info logging?</b>", defaultValue: false, submitOnChange: false, width: 2)
                    input (name: "isLogTrace", type: "bool", title: "<b>Enable trace logging?</b>", defaultValue: false, submitOnChange: false, width: 2)
                    input (name: "isLogDebug", type: "bool", title: "<b>Enable debug logging?</b>", defaultValue: false, submitOnChange: false, width: 2)
                    input (name: "isLogWarn",  type: "bool", title: "<b>Enable warn logging?</b>", defaultValue: true, submitOnChange: false, width: 2)
                    input (name: "isLogError",  type: "bool", title: "<b>Enable error logging?</b>", defaultValue: true, submitOnChange: false, width: 2, newLineAfter: true)
                    paragraph line(1)
                    
                    paragraph body('<b>Support Functions</b>')
                    input(name: 'defaultStyles'  , type: 'button', title: 'Rebuild Default Styles', backgroundColor: '#27ae61', textColor: 'white', submitOnChange: true, width: 2)
                    input(name: 'removeLicense'  , type: 'button', title: 'De-Activate Software License', backgroundColor: '#27ae61', textColor: 'white', submitOnChange: true, width: 3)
                    input (name: "supportCode", title: "<b>Support Code</b>", type: "string", submitOnChange:true, width:3, defaultValue: "?")
                }
                else {
                    input(name: 'btnShowMore', type: 'button', title: 'More ▶', backgroundColor: 'DodgerBlue', textColor: 'white', submitOnChange: true, width: 2)  //▼ ◀ ▶ ▲
                }
            paragraph line(2)
            }
            //End of More
			
			//Now add a footer.
            myText = '<div style="display: flex; justify-content: space-between;">'
            myText += '<div style="text-align:left;font-weight:small;font-size:12px"> Developer: Gary J. Milne</div>'
            myText += '<div style="text-align:center;font-weight:small;font-size:12px">Version: ' + Version + '</div>'
            myText += '<div style="text-align:right;font-weight:small;font-size:12px">Copyright 2022 - 2023</div>'
            myText += '</div>'
            paragraph myText  
           //paragraph ("setupState is: $state.setupState")
           //input(name: "test"  , type: "button", title: "test", backgroundColor: "#27ae61", textColor: "white", submitOnChange: true, width: 2, newLineAfter: false)
        }
        
    }
        
        //Refresh the UI - neccessary for controls located on the same page.
        //log.info ("Refresh again")
        //refreshUI()
    }

def test(){
    initialize()
    showSection("Intro", true)
    state.setupState = 1
    state.hasMessage= ""
}


//Returns a short version of the Storage Device Name for this instance.
def getStorageShortName(){
    if (isLogInfo) log.info ("Storage Name is: ${state.myStorageDeviceDNI.toString()} ")
    if (state.myStorageDeviceDNI == "Tile_Builder_Storage_Device_1" ) return "TBSD1"
    if (state.myStorageDeviceDNI == "Tile_Builder_Storage_Device_2" ) return "TBSD2"
    if (state.myStorageDeviceDNI == "Tile_Builder_Storage_Device_3" ) return "TBSD3"
}

//Returns a long version of the Storage Device Name for this instance.
def getStorageLongName(){
    return state.myStorageDeviceDNI.toString()
}

//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Setup and UI Functions
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************

//Show the selected section and hide all the others.
def showSection(section, override){
    //if (state.inSetup == true && override == false) return
    state.showIntro = false
    state.showLicense = false
    state.showDevice = false
    state.showSetupComplete = false
    state.showCreateEdit = false
    state.showManage = false
    state.showMore = false
    
    if (section == "Intro" ) state.showIntro = true
    if (section == "License" ) state.showLicense = true
    if (section == "Device" ) state.showDevice = true
    if (section == "SetupComplete" ) state.showSetupComplete = true
    if (section == "CreateEdit" ) state.showCreateEdit = true
    if (section == "Manage" ) state.showManage = true
    if (section == "More" ) state.showMore = true
}

//This is the standard button handler that receives the click of any button control.
def appButtonHandler(btn) {
    switch (btn) {
        case 'test':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on test')
            test()
            break
        case 'btnNext1':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnNext1')
            state.setupState = 2
            showSection("Device", true)
            break
        case 'btnNext2':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnNext2')
            state.setupState = 3
            showSection("SetupComplete", true)
            break
        case 'btnNext3':
            state.setupState = 99
            showSection("CreateEdit", true)
            break
        case 'btnShowIntro':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnShowIntro')
            showSection("Intro", false)
            break
        case 'btnShowLicense':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnShowLicense')
            showSection("License", false)
            break
        case 'btnShowDevice':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnShowDevice')
            showSection("Device", false)
            break
        case 'btnShowCreateEdit':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnShowCreateEdit')
            showSection("CreateEdit", false)
            break
        case 'btnShowManage':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnShowManage')
            showSection("Manage", false)
            break
        case 'btnShowMore':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on btnShowMore')
            showSection("More", false)
            break
        case 'defaultStyles':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on defaultStyles')
            makeDefaultStyles()
            break
        case 'createDevice':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on createDevice')
            makeTileStorageDevice()
            break
        case 'connectDevice':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on connectDevice')
            connectTileStorageDevice()
            break
        case 'disconnectDevice':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on disconnectDevice')
            disconnectTileStorageDevice()
            break
        case 'deleteDevice':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on deleteDevice')
            deleteTileStorageDevice()
            break
		case 'deleteTile':
            if (isLogTrace) log.trace('appButtonHandler: Clicked on deleteTile')
            deleteTile()
            break
        case 'doNothing':
            break
        case 'activateLicense': 
            if (isLogTrace) log.trace('appButtonHandler: Clicked on activateLicense')
            if (activateLicense() == true ) state.activationState = "Success"
            else state.activationState = "Failed"
            break
        case 'removeLicense': 
            if (isLogTrace) log.trace('appButtonHandler: Clicked on removeLicense')
            state.isAdvancedLicense = false
            state.activationState = "Not Activated"
            break
    }
}

//This is called after a submit actions
void refreshUI() {
    if (selectedDevice == null ) selectedDevice = 'Tile Builder Storage Device 1'
    if (state.flags.selectedDeviceChanged == true && selectedDevice != null) {
        state.isStorageConnected = false
        if (selectedDevice != null ) log.info('selectedDevice is:' + selectedDevice)
        state.myStorageDevice = selectedDevice
        state.myStorageDeviceDNI = selectedDevice.replace(' ', '_')
        state.hasMessage = '<b>You must connect to a storage device in order to publish tiles.</b>'
        
    }
}

//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Storage Device Functions
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************

//Called by the child apps. Returns an open handle to the childDevice
def getStorageDevice() {
    if (state.isStorageConnected == true ) {
        deviceDNI = state.myStorageDeviceDNI
        myStorageDevice = getChildDevice(deviceDNI)
        if (isLogDebug) log.debug("Parent returning myStorageDevice is: $myStorageDevice")
        return    myStorageDevice
    }
    else {
        log.warn('getStorageDevice: There is no storage device connected.')
        return null
    }
}

//Create a Tile Builder Storage Device.
def makeTileStorageDevice() {
    if (isLogTrace) log.trace("makeTileStorageDevice: Attempting to create Tile Builder Storage Device: $selectedDevice")
    deviceName = selectedDevice.toString()
    deviceDNI = deviceName.replace(' ', '_')
    try {
        myChildDevice = addChildDevice('garyjmilne', 'Tile Builder Storage Driver', deviceDNI, [ isComponent:false, label: deviceName, name: deviceName] )
        if (myChildDevice) {
            if (isLogInfo) log.info ("makeTileStorageDevice: <b>Storage Device ${state.myStorageDevice} Created.</b>")
            state.hasMessage = "<b>Storage Device ${state.myStorageDevice} Created. You must connect to it before you can start publishing tiles.</b>"
            state.myStorageDevice = deviceName
            state.myStorageDeviceDNI = deviceDNI
        }
         else {
            log.warn = ("makeTileStorageDevice(): Device Creation Error! Does the device '$deviceName' already exist? Was it created by a different instance of Tile Builder?")
            state.hasMessage = "<b>makeTileStorageDevice(): Device Creation Error! Does the device '$deviceName' already exist? Was it created by a different instance of Tile Builder?</b>"
         }
    }
    catch (ex) {
        log.error('makeTileStorageDevice(): Device Creation Error! Does the device already exist.')
        state.hasMessage = '<b>Device Creation Error! Does the device already exist? Was it created by a different instance of Tile Builder?</b>'
        state.isStorageConnected = false
    }
}

//Connect to an existing Tile Storage Device
def connectTileStorageDevice() {
    if (isLogTrace) log.trace ('connectTileStorageDevice: Entering connectTileStorageDevice')
    deviceDNI = state.myStorageDeviceDNI
    if (isLogDebug) log.debug("Connecting to Storage Device: $deviceDNI")
    try {
        myChildDevice = getChildDevice(deviceDNI)
        if (isLogDebug) log.debug ("myChildDevice is: $myChildDevice")
        if (myChildDevice != null) {
            state.hasMessage = "connectTileStorageDevice(): Connect Success ($myChildDevice)"
            if (isLogInfo) log.info ("connectTileStorageDevice(): Connect Success ($myChildDevice)")
            state.isStorageConnected = true
        }
         else {
            state.hasMessage = '<b>Device Connection Error! Does the device exist? Was it created by a different instance of Tile Builder?</b>'
            state.isStorageConnected = false
         }
    }
    catch (ex) {
        log.error("connectTileStorageDevice(): Failed - $selectedDevice. Exception:$ex")
        state.hasMessage = "<b>Exception encountered. Connection to '${selectedDevice}' failed.</b>"
        state.isStorageConnected = false
    }
}

//Disonnect from an existing Tile Storage Device
def disconnectTileStorageDevice() {
    if (isLogTrace) log.trace ('disconnectTileStorageDevice: Entering disconnectTileStorageDevice')
    deviceDNI = state.myStorageDeviceDNI
    if (isLogInfo) log.info("Disconnecting from Storage Device: $deviceDNI")
    try {
        myChildDevice = getChildDevice(deviceDNI)
        if (myChildDevice == true ) {
            if (isLogInfo) log.info("disconnectTileStorageDevice(): Successfully disconnected from $myChildDevice")
            state.hasMessage = ("<b>Successfully disconnected from $myChildDevice.</b>")
            state.myStorageDevice = ''
            state.myStorageDeviceDNI = ''
            state.isStorageConnected = false
        }
        else {
            if (isLogInfo) log.info("connectTileStorageDevice(): No connection to $myChildDevice to disconnect.")
            state.hasMessage = "<b>No connection to $deviceDNI.</b>"
            state.isStorageConnected = false
        }
    }
    catch (ex) {
        log.warn("connectTileStorageDevice: Error disconnecting from $myChildDevice. Exception:$ex")
        state.hasMessage = "<b>Exception encountered. Error disconnecting from $myChildDevice. </b>"
        state.isStorageConnected = true
    }
}

//Delete a Tile Builder Storage Device.
def deleteTileStorageDevice() {
    if (isLogTrace) log.trace ('deleteTileStorageDevice: Entering deleteTileStorageDevice')
    myDeviceDNI = state.myStorageDeviceDNI
    state.hasMessage = "<b>Device Deletion initiated for $myDeviceDNI.</b>"
    if (isLogInfo) log.info("deleteTileStorageDevice: Initiating deletion of ${myDeviceDNI}.")
    deleteChildDevice("$myDeviceDNI")
    state.isStorageConnected = false
}

//Get a list of tiles from the device
def getTileList() {
    if (isLogTrace) log.trace ('getTileList: Entering getTileList')
    def tileList = []
    myDevice = getChildDevice(state.myStorageDeviceDNI)
    if (isLogDebug) log.debug("getTileList: myDevice: $myDevice")
    if (state.isStorageConnected == true) tileList = myDevice.getTileList()
    return tileList
}

//Get a list of tiles from the device sorted by activity date.
def getTileListByActivity() {
    if (isLogTrace) log.trace ('getTileListbyActivity: Entering getTileListbyActivity')
    def tileList = []
    myDevice = getChildDevice(state.myStorageDeviceDNI)
    if (isLogDebug) log.debug("getTileList: myDevice: $myDevice")
    if (state.isStorageConnected == true) tileList = myDevice.getTileListByActivity()
    return tileList
}

//Delete a Tile Builder Tile on connected Storage Device.
def deleteTile() {
    if (isLogTrace) log.trace ('deleteTile: Entering deleteTile')
    myDeviceDNI = state.myStorageDeviceDNI
	
	//Test to see if it is a valid tile selection
	if (tilesInUse == null || tilesInUse.size() < 5 ){
		log.info ("deleteTile: Invalid selection: Nothing done.")
		return
	}
	myArr = tilesInUse.tokenize(':')
	//log.debug ("myArr is: ${myArr}")
	selectedTile = myArr[0]
	//log.debug ("selectedTile is: ${selectedTile}")
	selectedTile = selectedTile.replace("tile","")
	//log.debug ("Tile Number is: ${selectedTile}")
	myDevice = getChildDevice(state.myStorageDeviceDNI)
	if (state.isStorageConnected == true) {
		log.info ("deleteTile: Delete tile initiated for tile number ${selectedTile} on device: ${myDeviceDNI}")
		myDevice.deleteTile(selectedTile)
	}
}

def checkLicense() {
	return state.isAdvancedLicense
}


//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Style Related Functions
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************

//Creates all of the default internal styles.
def makeDefaultStyles() {
    if (isLogTrace) log.trace ('makeDefaultStyles: Entering makeDefaultStyles')

    styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tilePreview#=5, #isFrame#=true, #fbc#=#000000, #tc#=#f6cd00, #isKeyword1#=false, #isKeyword2#=false, #bp#=3, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=140, #shcolor#=#f6cd00, #fc#=#000000, #to#=1, #rabc#=#dff8aa, #hbc#=#f6cd00, #shblur#=2, #hts#=100, #bm#=Collapse, #rtc#=#000000, #hbo#=1, #iFrameColor#=#fffada, #shver#=2, #tff#=Comic Sans MS, #isTitleShadow#=false, #rp#=0, #comment#=?, #tp#=3, #th#=Auto, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.8, #shhor#=2, #htc#=#000000, #rbc#=#fbed94, #fa#=Center, #rts#=80, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #bo#=1, #fs#=60, #rta#=Center, #isFooter#=false, #tw#=90, #bfs#=18, #bc#=#000000, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Class1#=@keyframes A{0%{transform:rotate(-360deg)}100% {transform:rotate(0)}}|#Row#=animation:A 2s ease 0s 1 normal forwards| #title#=font-weight:900']
    style = styleA + styleB
    state.'*Style-AM Banana' = style

	styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tc#=#000000, #isKeyword1#=false, #isKeyword2#=false, #bp#=10, #isHeaders#=false, #hp#=0, #hta#=Center, #ts#=150, #shcolor#=#7a7a7a, #fc#=#000000, #to#=1, #rabc#=#dff8aa, #hbc#=#000000, #shblur#=10, #hts#=100, #bm#=Collapse, #rtc#=#ffffff, #hbo#=1, #iFrameColor#=#fcfcfc, #shver#=2, #tff#=Comic Sans MS, #isTitleShadow#=true, #rp#=0, #comment#=?, #tp#=3, #th#=Auto, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.3, #isFrame#=false, #shhor#=2, #htc#=#000000, #rbc#=#292929, #tilePreview#=5, #fa#=Center, #rts#=110, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #bo#=1, #fs#=90, #fbc#=#000000, #rta#=Center, #isFooter#=true, #tw#=90, #bfs#=18, #bc#=#ffffff, #ratc#=#000000, #bs#=Solid')
    styleB = ['overrides':'#Data#=transform: rotateX(10deg) rotateY(15deg);background: linear-gradient(45deg, #fff 0%, #000 50%,#fff 100%);']
    style = styleA + styleB
    state.'*Style-AM Black and White' = style

    styleA = convertStyleStringToMap('#tc#=#050505, #isKeyword1#=false, #bp#=5, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=140, #shcolor#=#d7dce0, #tbc#=#908989, #fc#=#000000, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#b71a3b, #hbc#=#0063b1, #shblur#=2, #hts#=100, #isCustomSize#=false, #bm#=Seperate, #rtc#=#050505, #customWidth#=200, #k1#=?, #hbo#=1, #iFrameColor#=#908989, #shver#=2, #tff#=Arial Black, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=false, #rp#=0, #top1#=[1], #comment#=?, #tp#=5, #customHeight#=190, #hts2#=125, #th#=85, #tcv1#=100, #isAlternateRows#=false, #isTitle#=true, #br#=25, #ta#=Center, #isComment#=false, #rbo#=0.6, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=2, #htc#=#cbcbc8, #rbc#=#7fb2e7, #top2#=[3], #fa#=Left, #rts#=80, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=80, #fbc#=#000000, #rta#=Center, #isFooter#=false, #ktr1#=?, #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#1e1e20, #ratc#=#ffffff, #bw#=3, #bs#=Solid')
    styleB = ['overrides':'#Title#=text-shadow: 1px 1px 2px LightSkyBlue, 0 0 25px DodgerBlue, 0 0 5px darkblue']
    style = styleA + styleB
    state.'*Style-AM Blue Buttons' = style
	
	styleA = convertStyleStringToMap('#tc#=#222f3c, #isKeyword1#=false, #bp#=5, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=120, #shcolor#=#ffffff, #tbc#=#aaa9ad, #fc#=#66cbe0, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#23303e, #shblur#=4, #hts#=100, #isCustomSize#=false, #bm#=Seperate, #rtc#=#d5d5d7, #customWidth#=200, #k1#=?, #hbo#=1, #iFrameColor#=#696969, #shver#=0, #tff#=Arial Black, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=true, #rp#=0, #top1#=[1], #comment#=?, #tp#=3, #customHeight#=290, #hts2#=125, #th#=Auto, #tcv1#=100, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=0, #htc#=#c0c0c0, #rbc#=#5b6db2, #top2#=[3], #fa#=Center, #rts#=80, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=100, #fbc#=#000000, #rta#=Center, #isFooter#=false, #ktr1#=?, #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#ada9a9, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Table#=background: linear-gradient(0deg, #bdc3c7 0%, #2c3e50 40%)']
    style = styleA + styleB
    state.'*Style-AM Blue Grey' = style
	
	styleA = convertStyleStringToMap('#tc#=#fffafa, #isKeyword1#=false, #bp#=3, #ktr2#=?, #isHeaders#=false, #hp#=0, #hta#=Center, #ts#=100, #shcolor#=#7a7a7a, #tbc#=#282828, #fc#=#ffffff, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#000000, #shblur#=10, #hts#=100, #bm#=Collapse, #rtc#=#ffffff, #k1#=?, #hbo#=1, #iFrameColor#=#282828, #shver#=2, #tff#=Comic Sans MS, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=false, #rp#=0, #top1#=1, #comment#=?, #tp#=3, #hts2#=125, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.3, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=2, #htc#=#000000, #rbc#=#292929, #top2#=3, #fa#=Center, #rts#=75, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=75, #fbc#=#000000, #rta#=Center, #isFooter#=true, #ktr1#=?, #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#ffffff, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Row#=transform: rotate(1deg) | #Title#=transform: rotate(-1deg); | #ts#=160 | #footer#=padding:3px | #Data#=text-shadow: 1px 1px 3px #FFFFFF | #Title#=text-shadow: 1px 1px 3px #FFFFFF']
    style = styleA + styleB
    state.'*Style-AM Chalkboard' = style
	
    styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tc#=#000000, #isKeyword1#=false, #isKeyword2#=false,#bp#=5, #isHeaders#=false, #hp#=0, #hta#=Center, #ts#=150, #shcolor#=#000000, #fc#=#000000, #to#=1, #rabc#=#dff8aa, #hbc#=#ffffff, #shblur#=5, #hts#=100, #bm#=Seperate, #rtc#=#000000, #hbo#=1, #iFrameColor#=#bbbbbb, #shver#=0, #tff#=Roboto, #isTitleShadow#=false, #rp#=0, #comment#=?, #tp#=5, #th#=Auto, #isAlternateRows#=false, #isTitle#=false, #br#=0, #ta#=Center, #isComment#=false, #rbo#=1, #isFrame#=false, #shhor#=0, #htc#=#000000, #rbc#=#e7e4e4, #tilePreview#=2, #fa#=Center, #rts#=100, #isBorder#=false, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=false, #bo#=1, #fs#=80, #fbc#=#000000, #rta#=Left, #isFooter#=false, #tw#=100, #bfs#=18, #bc#=#050505, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'?']
    style = styleA + styleB
    state.'*Style-AM Everything Off' = style

    styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tilePreview#=5, #isFrame#=false, #fbc#=#000000, #isKeyword1#=false, #isKeyword2#=false, #bs#=Solid, #bm#=Collapse, #ft#=%time%, #isHeaders#=true, #hp#=0, #fc#=#000000, #hta#=Center, #ts#=140, #shcolor#=#bfe373, #bc#=#000000, #fs#=80, #rabc#=#E9F5CF, #hbc#=#90c226, #shblur#=4, #hts#=100, #br#=0, #ta#=Center, #rtc#=#000000, #tp#=0, #hbo#=1, #iFrameColor#=#908989, #shver#=0, #tff#=Verdana, #isTitleShadow#=true, #rp#=0, #comment#=?, #th#=Auto, #isAlternateRows#=true, #bw#=2, #isTitle#=true, #isComment#=false, #fa#=Center, #shhor#=0, #htc#=#000000, #rbc#=#BFE373, #rts#=90, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=false, #tc#=#000000, #rta#=Center, #bp#=10, #isFooter#=true, #tw#=100, #bfs#=18, #ratc#=#000000')
    styleB = ['overrides':'?']
    style = styleA + styleB
    state.'*Style-AM Greens' = style

	styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tc#=#de5b00, #isKeyword1#=false, #isKeyword2#=false, #bp#=10, #isHeaders#=true, #hp#=10, #hta#=Center, #ts#=200, #shcolor#=#ff1d00, #fc#=#000000, #to#=1, #rabc#=#f69612, #hbc#=#c64a10, #shblur#=2, #hts#=100, #bm#=Seperate, #rtc#=#ffff00, #hbo#=1, #iFrameColor#=#8d8686, #shver#=2, #tff#=Comic Sans MS, #isTitleShadow#=false, #rp#=6, #comment#=?, #tp#=5, #th#=Auto, #isAlternateRows#=true, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.7, #isFrame#=true, #shhor#=2, #htc#=#000000, #rbc#=#f69612, #tilePreview#=5, #fa#=Center, #rts#=100, #isBorder#=false, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #bo#=0.7, #fs#=80, #fbc#=#000000, #rta#=Center, #isFooter#=false, #tw#=Auto, #bfs#=18, #bc#=#050505, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Table#=box-shadow: #FFF 0 -1px 4px, #ff0 0 -2px 10px, #ff8000 0 -10px 20px, red 0 -18px 40px, 5px 5px 15px 5px rgba(0,0,0,0)']
    style = styleA + styleB
    state.'*Style-AM Halloween' = style
	
	styleA = convertStyleStringToMap('#isCustomSize#=false, #tc#=#e5e826, #isKeyword1#=true, #bp#=0, #ktr2#=[div classXglow]📬[/div], #isHeaders#=false, #hp#=6, #hta#=Center, #ts#=150, #shcolor#=#7a7a7a, #tbc#=#696969, #fc#=#3be800, #hc2#=#ca6f1e, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#000000, #shblur#=10, #hts#=60, #bm#=Collapse, #rtc#=#41ff00, #k1#=off, #hbo#=1, #iFrameColor#=#696969, #shver#=2, #tff#=Lucida, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=false, #rp#=0, #top1#=[1], #comment#=?, #tp#=3, #hts2#=300, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=1, #k2#=on, #isFrame#=false, #isThreshold2#=false, #shhor#=2, #htc#=#41ff00, #rbc#=#696969, #top2#=[3], #fa#=Center, #rts#=150, #isBorder#=false, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=300, #isKeyword2#=true, #bo#=1, #fs#=50, #fbc#=#000000, #rta#=Left, #isFooter#=false, #ktr1#=📭, #tw#=100, #bfs#=18, #hc1#=#f5f90b, #bc#=#c52b2b, #ratc#=#000000, #bw#=5, #bs#=Solid')
    styleB = ['overrides':'#Class1#= .glow {animation: glow 3s ease-in-out infinite alternate;} @keyframes glow {from {text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 35px #e60073;}to {text-shadow: 0 0 10px #fff, 0 0 15px #ff4da6;}} | #row#=text-align: center |#rp#=0 | #bp#=-5| #row#=text-align: center |#rp#=0 | #bp#=-5']
    style = styleA + styleB
    state.'*Style-AM Mailbox (See Docs)' = style
	
	styleA = convertStyleStringToMap('#tc#=#751f2e, #isKeyword1#=false, #bp#=5, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=120, #shcolor#=#ffffff, #tbc#=#ffffff, #fc#=#66cbe0, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#832333, #shblur#=4, #hts#=100, #isCustomSize#=false, #bm#=Seperate, #rtc#=#f4b53b, #customWidth#=200, #k1#=?, #hbo#=1, #iFrameColor#=#696969, #shver#=0, #tff#=Comic Sans MS, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=true, #rp#=0, #top1#=[1], #comment#=?, #tp#=3, #customHeight#=290, #hts2#=125, #th#=Auto, #tcv1#=100, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.9, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=0, #htc#=#f4b53b, #rbc#=#832333, #top2#=[3], #fa#=Center, #rts#=80, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=100, #fbc#=#000000, #rta#=Center, #isFooter#=false, #ktr1#=?, #tw#=100, #bfs#=18, #hc1#=#008000, #bc#=#d9b784, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Class1#=@keyframes myAnim {0% {opacity: 0;transform: rotate(-540deg) scale(0);}100% {opacity: 1;transform: rotate(0) scale(1);}} | #Header#=animation: myAnim 2s ease 0s 1 normal backwards; | #Row#=animation: myAnim 2s ease 0s 1 normal forwards;']
    style = styleA + styleB
    state.'*Style-AM Marooned' = style
	
	styleA = convertStyleStringToMap('#isCustomSize#=false, #tc#=#b2e0de, #isKeyword1#=false, #bp#=10, #isHeaders#=false, #hp#=5, #hta#=Center, #ts#=200, #shcolor#=#000000, #tbc#=#ffffff, #fc#=#000000, #hc2#=#CA6F1E, #to#=1, #rabc#=#dff8aa, #hbc#=#9ec1eb, #shblur#=3, #hts#=100, #bm#=Collapse, #rtc#=#282828, #hbo#=1, #iFrameColor#=#282828, #shver#=0, #tff#=Comic Sans MS, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=true, #rp#=10, #top1#=[1], #comment#=?, #tp#=15, #hts2#=125, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=1, #k2#=?, #isFrame#=true, #isThreshold2#=false, #shhor#=0, #htc#=#000000, #rbc#=#282828, #top2#=[3], #fa#=Center, #rts#=90, #isBorder#=false, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=60, #fbc#=#282828, #rta#=Center, #isFooter#=false, #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#000000, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides' : '#Title#=margin-top: 0px; font-size: 70px; font-weight: bold; color: #CFC547; text-align: center; letter-spacing: 5px; text-shadow: 16px 22px 11px rgba(168,158,32,0.8)']
    style = styleA + styleB
    state.'*Style-AM Menu Bar (See Docs)' = style
	
	styleA = convertStyleStringToMap('#tc#=#cfc547, #isKeyword1#=false, #bp#=10, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=200, #shcolor#=#000000, #tbc#=#282828, #fc#=#000000, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#c74343, #shblur#=3, #hts#=125, #bm#=Seperate, #rtc#=#282828, #k1#=?, #hbo#=0.2, #iFrameColor#=#696969, #shver#=0, #tff#=Comic Sans MS, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=false, #rp#=10, #top1#=[1], #comment#=?, #tp#=0, #hts2#=125, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=1, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=0, #htc#=#c5bc44, #rbc#=#696969, #top2#=[3], #fa#=Center, #rts#=90, #isBorder#=false, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=60, #fbc#=#282828, #rta#=Center, #isFooter#=false, #ktr1#=?, #tw#=100, #bfs#=18, #hc1#=#008000, #bc#=#000000, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Title#= letter-spacing: 5px; text-shadow: 16px 22px 11px rgba(168,158,32,0.8); background-color: #282828, ']
    style = styleA + styleB
    state.'*Style-AM Menu Bar Dual (See Docs)' = style
	
	styleA = convertStyleStringToMap('#isCustomSize#=false, #tc#=#66cbe0, #isKeyword1#=false, #bp#=5, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=150, #shcolor#=#7a7a7a, #tbc#=#ffffff, #fc#=#66cbe0, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#66cbe0, #shblur#=10, #hts#=140, #bm#=Collapse, #rtc#=#eb822e, #k1#=?, #hbo#=0.8, #iFrameColor#=#696969, #shver#=2, #tff#=Comic Sans MS, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=false, #rp#=0, #top1#=[1], #comment#=?, #tp#=3, #hts2#=125, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=1, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=2, #htc#=#eb822e, #rbc#=#d9ddc6, #top2#=[3], #fa#=Center, #rts#=110, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=false, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=100, #fbc#=#000000, #rta#=Center, #isFooter#=false, #ktr1#=?, #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#eb822e, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'?']
    style = styleA + styleB
    state.'*Style-AM Palm Springs' = style
	
	styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tc#=#000000, #isKeyword1#=false, #isKeyword2#=false, #bp#=10, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=140, #shcolor#=#bfe373, #fc#=#000000, #to#=1, #rabc#=#e9f5cf, #hbc#=#9bdbe8, #shblur#=4, #hts#=100, #bm#=Collapse, #rtc#=#fe7868, #hbo#=0.5, #iFrameColor#=#908989, #shver#=0, #tff#=Verdana, #isTitleShadow#=false, #rp#=0, #comment#=?, #tp#=0, #th#=Auto, #isAlternateRows#=false, #isTitle#=false, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.5, #isFrame#=false, #shhor#=0, #htc#=#650606, #rbc#=#ffffa0, #tilePreview#=5, #fa#=Center, #rts#=90, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #bo#=1, #fs#=80, #fbc#=#000000, #rta#=Center, #isFooter#=true, #tw#=100, #bfs#=18, #bc#=#000000, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Table#=background-image: repeating-radial-gradient(#0000 0% 6%,#c39f76 7% 13% ); background-size:40px 40px | #Row#=font-weight:bold']
    style = styleA + styleB
    state.'*Style-AM Pastel Swirl' = style
	
    styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tc#=#b2e0de, #isKeyword1#=false, #isKeyword2#=false, #bp#=10, #isHeaders#=false, #hp#=5, #hta#=Center, #ts#=140, #shcolor#=#000000, #fc#=#000000, #to#=1, #rabc#=#dff8aa, #hbc#=#9ec1eb, #shblur#=3, #hts#=100, #bm#=Seperate, #rtc#=#000000, #hbo#=1, #iFrameColor#=#888686, #shver#=0, #tff#=Comic Sans MS, #isTitleShadow#=false, #rp#=10, #comment#=?, #tp#=15, #th#=Auto, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=1, #isFrame#=true, #shhor#=0, #htc#=#000000, #rbc#=#b2e0de, #tilePreview#=5, #fa#=Center, #rts#=90, #isBorder#=false, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #bo#=1, #fs#=60, #fbc#=#624141, #rta#=Center, #isFooter#=false, #tw#=90, #bfs#=18, #bc#=#000000, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Table#=box-shadow: 0px 0px 10px 10px #E8DD95;']
    style = styleA + styleB
    state.'*Style-AM Sea Foam Glow' = style
   
    styleA = convertStyleStringToMap('#isCustomSize#=false, #tbc#=#ffffff, #tc#=#000000, #isKeyword1#=false, #isKeyword2#=false, #bp#=0, #isHeaders#=true, #hp#=6, #hta#=Center, #ts#=150, #shcolor#=#7a7a7a, #fc#=#3be800, #to#=1, #rabc#=#dff8aa, #hbc#=#000000, #shblur#=10, #hts#=60, #bm#=Collapse, #rtc#=#41ff00, #hbo#=1, #iFrameColor#=#929090, #shver#=2, #tff#=Lucida, #isTitleShadow#=false, #rp#=6, #comment#=?, #tp#=3, #th#=Auto, #isAlternateRows#=false, #isTitle#=false, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.5, #isFrame#=false, #shhor#=2, #htc#=#41ff00, #rbc#=#000000, #tilePreview#=1, #fa#=Center, #rts#=50, #isBorder#=false, #isScrubHTML#=true, #rto#=0.7, #hto#=1, #isOverrides#=true, #bo#=0, #fs#=50, #fbc#=#000000, #rta#=Center, #isFooter#=true, #tw#=100, #bfs#=18, #bc#=#ffffff, #ratc#=#000000, #bw#=5, #bs#=Solid')
    styleB = ['overrides':'#Table#=background: linear-gradient(180deg, #060606 0%, #11610B 100%)']
    style = styleA + styleB
    state.'*Style-AM Terminal' = style
	
	styleA = convertStyleStringToMap('#tc#=#000000, #isKeyword1#=false, #bp#=0, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=120, #shcolor#=#f6cd00, #tbc#=#696969, #fc#=#000000, #hc2#=#ca6f1e, #ttr1#=?, #to#=1, #rabc#=#a8c171, #hbc#=#f9e66c, #shblur#=2, #hts#=85, #isCustomSize#=false, #bm#=Seperate, #rtc#=#000000, #customWidth#=200, #k1#=?, #hbo#=1, #iFrameColor#=#696969, #shver#=2, #tff#=Comic Sans MS, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=false, #rp#=0, #top1#=[1], #comment#=?, #tp#=0, #customHeight#=190, #hts2#=125, #th#=Auto, #tcv1#=100, #isAlternateRows#=false, #isTitle#=false, #br#=10, #ta#=Center, #isComment#=false, #rbo#=1, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=2, #htc#=#000000, #rbc#=#d1dd2c, #top2#=[3], #fa#=Left, #rts#=70, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=80, #fbc#=#282828, #rta#=Center, #isFooter#=true, #ktr1#=?, #tw#=100, #bfs#=18, #hc1#=#008000, #bc#=#000000, #ratc#=#000000, #bw#=3, #bs#=Dotted')
    styleB = ['overrides':'#Table#=transform: rotate(2deg) translate(0px,8px)']
    style = styleA + styleB
    state.'*Style-AM Tickets' = style
	
	styleA = convertStyleStringToMap('#isCustomSize#=false, #tc#=#412f86, #isKeyword1#=false, #bp#=5, #ktr2#=?, #isHeaders#=true, #hp#=0, #hta#=Center, #ts#=175, #shcolor#=#ffc62f, #tbc#=#e3b994, #fc#=#000000, #hc2#=#ca6f1e, #ttr1#=?, #to#=1, #rabc#=#f7c104, #hbc#=#4c247e, #shblur#=4, #hts#=140, #bm#=Collapse, #rtc#=#f7f7f7, #k1#=open, #hbo#=0.9, #iFrameColor#=#dbc0a9, #shver#=0, #tff#=Brush Script MT, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=true, #rp#=0, #top1#=[1], #comment#=?, #tp#=3, #hts2#=125, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.7, #k2#=?, #isFrame#=false, #isThreshold2#=false, #shhor#=0, #htc#=#f7c104, #rbc#=#4d2081, #top2#=[3], #fa#=Center, #rts#=110, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=false, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=0.6, #fs#=90, #fbc#=#000000, #rta#=Center, #isFooter#=false, #ktr1#=[div class=cl99]Open[/div], #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#f7c104, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'?']
    style = styleA + styleB
    state.'*Style-AM Vikings' = style

    styleA = convertStyleStringToMap('#isCustomSize#=false, #tc#=#d6ae7b, #isKeyword1#=false, #bp#=6, #ktr2#=?, #isHeaders#=false, #hp#=0, #hta#=Center, #ts#=200, #shcolor#=#000000, #tbc#=#ffffff, #fc#=#d6ae7b, #hc2#=#CA6F1E, #ttr1#=?, #to#=1, #rabc#=#dff8aa, #hbc#=#9ec1eb, #shblur#=10, #hts#=100, #bm#=Collapse, #rtc#=#786854, #k1#=?, #hbo#=1, #iFrameColor#=#000000, #shver#=2, #tff#=Brush Script MT, #isThreshold1#=false, #ttr2#=?, #isTitleShadow#=true, #rp#=0, #top1#=[1], #comment#=?, #tp#=3, #hts2#=125, #th#=Auto, #tcv1#=70, #isAlternateRows#=false, #isTitle#=true, #br#=0, #ta#=Center, #isComment#=false, #rbo#=0.6, #k2#=?, #isFrame#=true, #isThreshold2#=false, #shhor#=2, #htc#=#000000, #rbc#=#ba8c63, #top2#=[3], #fa#=Center, #rts#=150, #isBorder#=true, #isScrubHTML#=true, #rto#=1, #hto#=1, #isOverrides#=true, #tcv2#=30, #hts1#=125, #isKeyword2#=false, #bo#=1, #fs#=90, #fbc#=#560b0b, #rta#=Center, #isFooter#=true, #ktr1#=?, #tw#=90, #bfs#=18, #hc1#=#008000, #bc#=#786854, #ratc#=#000000, #bw#=2, #bs#=Solid')
    styleB = ['overrides':'#Row#=text-shadow:3px 3px 8px #660000']
    style = styleA + styleB
    state.'*Style-AM Wood' = style

	return
}

//Converts an built-in internal Style in string form into a Map for storage
def convertStyleStringToMap(String style) {
    if (isLogTrace) log.trace ('convertStyleStringToMap: Entering convertStyleStringToMap')
    style = style.replace(', ', ', ')
	
    if (isLogDebug) log.debug ("Style is: ${style}")
    def myStyle = [:]

    myArr = style.tokenize(',')
	//log.debug ("myArr is: ${myArr}")
    myArr.each {
        details = it.tokenize('=')
        if (isLogDebug) log.debug ("Details is: ${details}")
        if (details[0] != null ) d0 = details[0].trim()
		//log.debug ("d0 is: ${d0}")
        if (details[1] != null ) d1 = details[1].trim()
		//log.debug ("d1 is: ${d1}")
		//If the style string has an embedded = sign like class=abc it will result in a third item in the details array.
		if (details[2] != null ) {
			//In which case we concatenate details[1] + "=" + details[2] to restore the substring that was split up by the earlier tokenize '='
			d1 = d1 + "=" + details[2].trim()
			//log.debug ("d1 is now: ${d1}")
		}
	    if (d0 != null && d1 != null ) myStyle."${d0}" = d1
    }
    if (isLogDebug) log.debug ("myStyle is: ${myStyle}")
    return myStyle
}

//Saves the settings received from a child app as a new style.
def saveStyle(styleName, styleMap) {
    if (isLogTrace) log.trace ('saveStyle: Entering saveStyle')
    if (isLogInfo) log.info("Parent - Saving style: '${saveName}' with settings: ${styleMap}")
    state."${styleName}" = styleMap
}

//Returns all of the settings in a style to the child app.
def loadStyle(String styleName) {
    if (isLogTrace) log.trace ('loadStyle: Entering loadStyle')
    def myStyle = [:]
    myStyle = state."${styleName}"
    if (isLogDebug) log.debug("Parent - Returning style: '${styleName}' with settings: ${myStyle}")
    return myStyle
}

//Deletes the selected Style.
def deleteStyle(String deleteStyle) {
    if (isLogTrace) log.trace ('deleteStyle: Entering deleteStyle')
    state.remove(deleteStyle)
    if (isLogInfo) log.info("Parent - Deleted style: '${deleteStyle}'")
}

//Returns a list of state key names that begin with the word "Style-"
def listStyles() {
    if (isLogTrace) log.trace ('listStyles: Entering listStyles')
    def myList = []
    state.each {
        //Only process those with a matching name.
        if ( it.toString().indexOf('Style-AM') == 0  || it.toString().indexOf('*Style-AM') == 0 ) {
            data = it.toString().tokenize('=')
            myVal = data[0].toString()
            myList.add(myVal)
        }
    }
    return myList.sort()
}

//*****************************************************************************************************
//Utility Functions
//*****************************************************************************************************

//Get the license type the user has selected.
def isAdvLicense(){
    if (isLogInfo) ("License:" + isAdvLicense)
    return isAdvLicense
}

//Functions to enhance text appearance
String bold(s) { return "<b>$s</b>" }
String italic(s) { return "<i>$s</i>" }
String underline(s) { return "<u>$s</u>" }
String dodgerBlue(s) { return '<font color = "DodgerBlue">' + s + '</font>' }
String myTitle(s1, s2) { return '<h3><b><font color = "DodgerBlue">' + s1 + '</font></h3>' + s2 + '</b>' }
String red(s) { return '<r style="color:red">' + s + '</r>' }
String green(s) { return '<g style="color:green">' + s + '</g>' }
String orange(s) { return '<g style="color:orange">' + s + '</g>' }

//Set the titles to a consistent style.
def titleise(title) {
    title = "<span style='color:#1962d7;text-align:left; margin-top:0em; font-size:20px'><b><u>${title}</u></b></span>"
}

//Set the titles to a consistent style without underline
def titleise2(title) {
    title = "<span style='color:#1962d7;text-align:left; margin-top:0em; font-size:20px'><b>${title}</b></span>"
}

//Set the notes to a consistent style.
String note(myTitle, myText) {
    return "<span style='color:#17202A;text-align:left; margin-top:0.25em; margin-bottom:0.25em ; font-size:16px'>" + '<b>' + myTitle + '</b>' + myText + '</span>'
}

//Set the body text to a consistent style.
String body(myBody) {
    return "<span style='color:#17202A;text-align:left; margin-top:0em; margin-bottom:0em ; font-size:18px'>"  + myBody + '</span>&nbsp'
}

//Produce a horizontal line of the speficied width
String line(myHeight) {
    return "<div style='background-color:#005A9C; height: " + myHeight + "px; margin-top:0em; margin-bottom:0em ; border: 0;'></div>"
}

//Displays a sample HTML table on the Parent App Screen.
/* groovylint-disable-next-line GetterMethodCouldBeProperty */
def getSample() {
    return '<head><style>.cl1{animation:myAnim 1s linear 0s infinite normal forwards} @keyframes myAnim{0%{transform:rotate(0deg)}100%{transform:rotate(360deg)} }table.qq{width:85%;height:70%;margin:Auto;font-family:Comic Sans MS;background-color:#ffffff;box-shadow:#FFF 0 -1px 4px, #ff0 0 -2px 10px, #ff8000 0 -10px 20px, red 0 -18px 40px, 5px 5px 15px 5px rgba(0,0,0,0)}.qq tr{color:rgba(255,255,0,1);text-align:Center}.qq td{background-color:rgba(246,150,18,0.7);font-size:80%}.qq th{background:rgba(198,74,16,1);color:rgba(0,0,0,1);text-align:Center}.qq tr:nth-child(even){color:#000000;background-color:#f69612}hqq1{color:#008000;font-size:125%}</style></head><body><table class=qq><tr><th colspan=2>Fan Status</th></tr><tbody><tr><td>Attic</td><td>off</td></tr><tr><td>Bathroom</td><td>off</td></tr><tr><td>Bedroom</td><td><hqq1><div class=cl1>❌</div></hqq1></td></tr><tr><td>Circulation</td><td>off</td></tr><tr><td>Porch</td><td>off</td></tr></tbody></table></body>'
}

String obfuscateStrings(String str1, String str2) {
    def result = ""
    int maxLength = Math.max(str1.length(), str2.length())

    for (int i = 0; i < maxLength; i++) {
        if (i < str1.length()) {
            result += str1.charAt(i)
        }
        if (i < str2.length()) {
            result += str2.charAt(i)
        }
    }
    return result
}

def activateLicense(){
    String hubUID = getHubUID()
    def P1 = (hubUID.substring(0, 8)).toUpperCase()
    def P2 = (hubUID.substring(Math.max(hubUID.length() - 8, 0))).toUpperCase()
    
    myResult = obfuscateStrings(P1.reverse().toString(), P2.reverse().toString())
    
    def firstHalf = myResult.substring(0, 8)
    def secondHalf = myResult.substring(8, 16)
    
    def key = firstHalf.toUpperCase() + "-" + secondHalf.toUpperCase()
    
    if (key == licenseKey) {
        state.isAdvancedLicense = true
        return true
        }
    else return false
}

def getID(){
    //Create a Quasi Unique Identifier
    String hubUID = getHubUID()
    def P1 = (hubUID.substring(0, 8)).toUpperCase()
    def P2 = (hubUID.substring(Math.max(hubUID.length() - 8, 0))).toUpperCase()
    return ("${P1}-${P2}")
}


//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Button Related Functions
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************

String buttonLink(String btnName, String linkText, int buttonNumber) {
    font = chooseButtonFont(buttonNumber)
    color = chooseButtonColor(buttonNumber)
    text = chooseButtonText(buttonNumber, linkText)
    return "<div class='form-group'><input type='hidden' name='${btnName}.type' value='button'></div><div><div class='submitOnChange' onclick='buttonClick(this)' style='color:${color};cursor:pointer;font-size:${font}px'>${text}</div></div><input type='hidden' name='settings[$btnName]' value=''>"
}

def chooseButtonColor(buttonNumber) {
    return (buttonNumber == settings.activeButton) ? '#00FF00' : '#000000'
}

def chooseButtonFont(buttonNumber) {
    return (buttonNumber == settings.activeButton) ? 20 : 15
}

def chooseButtonText(buttonNumber, buttonText) {
    return (buttonNumber == settings.activeButton) ? "<b>$buttonText</b>" : "<b>$buttonText</b>"
}

//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Child Functions - Overrides Helper - These are all called during the design process. Functions called during the Table generation process have been relocated to the child app for efficiency.
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************

def getOverridesListAll(){
    def overridesMapAll = getOverrideAnimationList()    
    overridesMapAll += getOverrideFieldReplacementList()
    overridesMapAll += getOverrideTextList()
    overridesMapAll += getOverrideBorderList()
    overridesMapAll += getOverrideBackgroundList()
    overridesMapAll += getOverrideClassList()
    overridesMapAll += getOverrideMarginPaddingList()
    overridesMapAll += getOverrideTransformList()
    overridesMapAll += getOverrideMiscList()
    return overridesMapAll
}

//Each record is a map entry that looks like this. "Short description: Long Description" : "sample command"
def getOverrideAnimationList(){
    return [
    'Fade: Fades in an object on refresh.' : '#Class1#=@keyframes fade {0% {opacity: 0}100% {opacity: 1}} | #Table#=animation: fade 5s linear 0s 1 normal forwards;',
    'Hue: Constantly change the background hue between two color values.' : '#Class1#=@keyframes hue {50%{background-color: #cc2b5e} 100%{background-color:#753a88}} | #Table#=animation: hue 10s ease 0s infinite alternate-reverse forwards;',
    'Ping: Performs a ping effect on an object' : '#Class1#=@keyframes ping {0% {opacity: 0.8;transform: scale(0.2);} 90% {opacity: .5;transform: scale(1.2);} 100% {opacity: 1;transform: scale(1.0);}} | #Table#=animation: ping 1s ease 0s 1 normal forwards;' ,
    'Pulse: Causes an object to pulsate' : '#Class1#=@keyframes pulse {0% {transform: scale(0.8);} 100% {transform: scale(1);}} | #Table#=animation: pulse 1s linear 0s 2 alternate-reverse forwards;',
    'Roll: Causes an object to roll into place. ' : '#Class1#=@keyframes roll {0% {opacity: 0;transform: translateX(-125px) rotate(-500deg);}100% {opacity: 1;transform: translateX(0px) rotate(0deg);}} | #Table#=animation: roll 1s linear 0s 1 alternate forwards;',
    'Slide: Slide an object back and forth continuously' : '#Class1#=@keyframes slide {0% {transform: translateX(-20px);} 100% {transform: translateX(20px);}} | #Table#=animation:slide 2s linear 0s 2 alternate-reverse; ',
    'Spin: Spin an object on a refresh.' : '#Class1#=@keyframes spin {0% {opacity: 0;transform: rotate(-540deg) scale(0);}100% {opacity: 1;transform: rotate(0) scale(1);}} | #Row#=animation: spin 2s ease 0s 1 normal forwards;',
    'Glow: Places an animated glow around text' : '#Class1#=@keyframes glow {from {text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #ff0000;}to {text-shadow: 0 0 10px #fff, 0 0 15px #00FF00;}} | #Table#=animation: glow 5s ease-in-out infinite alternate;',
    'Scale: Changes the X and Y scale of an object.' : '#Class1#=@keyframes scale {0% {transform: scaleY(2);}100% {transform: scaleY(1);}} | #Table#=animation: scale 1s linear'
    ]
}

def getOverrideFieldReplacementList(){
    return [
    'Title: Replace the Title text, alignment, color, opacity and size.' : '#tt#=My Title | #ta#=left | #tc#=#0000FF | #to#=0.8 | #ts#=300',
    'Header: Replace the Header alignment, color, background color, opacity and padding.' : '#hta#=left | #htc#=#0000FF | #hbc#=#813795 | #hbo#=0.5 | #hts#=150 | #hto#=0.5 | #hp#=5',
    'Row: Replace the Row alignment, color, background color, opacity and padding.' : '#rta#=left | #rtc#=#0000FF | #rbc#=#813795 | #rbo#=0.5 | #rts#=150 | #rto#=0.5 | #rp#=5',
    'Border: Replace the Border color, style, radius, width and padding.' : '#bc#=#0000FF | #bs#=dotted | #br#=25 | #bw#=10 | #bp#=5',
    'Footer: Replace the Footer text, alignment, color and size.' : '#ft#=My Footer | #fa#=right | #fc#=#FF00FF| #fs#=100',
    'Named: Replace Named Variables: Place a border around the title, footer and table objects if visible.' : '#title#=border: 5px dashed red | #footer#=border: 5px groove green |  #border#=border: 6px solid white' 
    ]
}

def getOverrideBackgroundList(){
    return [
    'Solid Color: Sets the background color of an object.' : '#Table#=background-color: #ff0000;',
    'Color Gradient #1: Sets the background of an object as a gradient between 2 or more colors. Also sets the row background opacity to 0.5.' : '#Table#=background: linear-gradient(70deg, #6c2b5e 0%, #c5cc88 100%) | #rbo#=0.2',
    'Color Gradient #2: From https://bennettfeely.com/gradients/ ' : '#Table#=background:linear-gradient(cyan,transparent),linear-gradient(-45deg,magenta,transparent),linear-gradient(45deg,yellow,transparent);background-blend-mode: multiply;',
    'Conical Gradient: Sets a repeating gradient in a cone from a central point.' : '#Table#=background-image: repeating-conic-gradient(red 10%, yellow 15%);border-radius: 5% | #hbo#=0.3 | #rbo#=0.9;',
    'Radial Gradient: Sets a circular gradient that diffuses at the edges.' : '#Table#=background: radial-gradient(circle at 100%, #333, #333 50%, #eee 75%, #333 75%);',
    'Repeating Pattern #1: Sets a repeating set of slanted lines.' : '#Row#=background-image: repeating-linear-gradient(45deg, red 0px, red 10px, red 10px, yellow 10px, yellow 20px) | #rbo#=0.6',
	'Repeating Pattern #2: Sets a repeating swirl background effect.' : '#Table#=background-image: repeating-radial-gradient(#0000 0% 6%,#c39f76 7% 13% ); background-size:40px 40px | #Row#=font-weight:bold',
    'Transparent Texture : From https://www.transparenttextures.com/patterns/wood-pattern.png' : "#Table#=background-color: #695100;background-image: url('https://www.transparenttextures.com/patterns/wood-pattern.png');",

'Background Blend Mode: From https://bennettfeely.com/gradients/'  : '#Table#=background: radial-gradient(circle at bottom left,transparent 0,transparent 2em,beige 2em,beige 4em,transparent 4em,transparent 6em,khaki 6em,khaki 8em,transparent 8em,transparent 10em),\
radial-gradient(circle at top right,transparent 0,transparent 2em,beige 2em,beige 4em,transparent 4em,transparent 6em,khaki 6em,khaki 8em,transparent 8em,transparent 10em),\
radial-gradient(circle at top left,transparent 0,transparent 2em,navajowhite 2em,navajowhite 4em,transparent 4em,transparent 6em,peachpuff 6em,peachpuff 8em,transparent 8em,transparent 10em),\
radial-gradient(circle at bottom right,transparent 0,transparent 2em,palegoldenrod 2em,palegoldenrod 4em,transparent 4em,transparent 6em,peachpuff 6em,peachpuff 8em,transparent 8em,transparent 10em),\
blanchedalmond;background-blend-mode: multiply;background-size: 10em 10em;background-position: 0 0, 0 0, 5em 5em, 5em 5em;',
        
'Repeating Linear Gradient: Creates a plaid style effect.' : '#Table#=background:repeating-linear-gradient(50deg,#F7A37B,#F7A37B 1em,#FFDEA8 1em,#FFDEA8 2em,#D0E4B0 2em,#D0E4B0 3em,#7CC5D0 3em,#7CC5D0 4em,#00A2E1 4em,#00A2E1 5em,#0085C8 5em,#0085C8 6em),\
repeating-linear-gradient(-50deg,#F7A37B,#F7A37B 1em,#FFDEA8 1em,#FFDEA8 2em,#D0E4B0 2em,#D0E4B0 3em,#7CC5D0 3em,#7CC5D0 4em,#00A2E1 4em,#00A2E1 5em,#0085C8 5em,#0085C8 6em);background-blend-mode: multiply;',           

'Repeating Radial Gradient: From https://blog.logrocket.com/advanced-effects-with-css-background-blend-modes-4b750198522a/' : '#Table#= background:radial-gradient(khaki 40px,transparent 0,transparent 100%),radial-gradient(skyblue 40px,transparent 0,transparent 100%),\
radial-gradient(pink 40px,transparent 0,transparent 100%), snow;background-blend-mode: multiply;background-size: 100px 100px;background-position: 0 0, 33px 33px, -33px -33px;',

'Repeating Isometric : From https://www.magicpattern.design/tools/css-backgrounds' : '#Table#=background-color: #e5e5f7; opacity: 0.8;background-image: linear-gradient(30deg, #444cf7 12%, transparent 12.5%, transparent 87%, #444cf7 87.5%, #444cf7),\
linear-gradient(150deg, #444cf7 12%, transparent 12.5%, transparent 87%, #444cf7 87.5%, #444cf7), linear-gradient(30deg, #444cf7 12%, transparent 12.5%, transparent 87%, #444cf7 87.5%, #444cf7), linear-gradient(150deg, #444cf7 12%, transparent 12.5%, transparent 87%, #444cf7 87.5%, #444cf7),\
linear-gradient(60deg, #444cf777 25%, transparent 25.5%, transparent 75%, #444cf777 75%, #444cf777), linear-gradient(60deg, #444cf777 25%, transparent 25.5%, transparent 75%, #444cf777 75%, #444cf777);background-size: 20px 35px;background-position: 0 0, 0 0, 10px 18px, 10px 18px, 0 0, 10px 18px;'
    ]
}

def getOverrideBorderList(){
    return [
    "Border Spacing: Sets the distance between adjacent borders. When combined with border mode 'seperate', border radius of 20 and color gradient it can produce a pleasing gradient button effect as shown here." : '#Table#=border-spacing: 15px 10px | #bs#=seperate | #br#=20 | #Data#=background: linear-gradient(0deg, #43cea2 0%, #185a9d 100%) | #Row#=font-weight: bold;',
    'Border Properties: Sets a border, border width, border type and border color.' : '#Header#=border: 5px dashed #B15656;',
    'Border Radius: Sets the radius of a border corner. If only one value is specified it applies to all corners' : '#Border#=border-radius:30px;',
    'Border Effect1: Eliminate outside edges of a grid for a tic-tac-toe appearance.' : '#Table#=border-collapse: collapse; border-style: hidden;',
	'Border Effect2: Use a Radial Gradient to highlight row data when using Border Mode=Seperate.' : '#Border#=background: radial-gradient(transparent 65%, #90C226 95%) | #Data#=font-weight: bold; letter-spacing: 2px; | #bs#=seperate' 
    ]
}

def getOverrideClassList(){
    return [ 
	'Class Example 1: Rotate an element 540 degrees when activated. Called with #element#=animation etc.' : '#Class1#=@keyframes myAnim {0% {opacity: 0;transform: rotate(-540deg) scale(0);}100% {opacity: 1;transform: rotate(0) scale(1);} } | #Row#=animation: myAnim 2s ease 0s 1 normal forwards;',
    'Class Example 2: Blink an element twice when activated. Called with #element#=animation etc.' : '#Class1#=@keyframes myAnim {0%,50%,100% {opacity: 1;}25%,75% {opacity: 0;} } | #Title#=animation: myAnim 2s ease 0s 1 normal forwards;',
	'Class Example 3: Change background color to red when activated. Called with [div class=cl99]My Value[/div] in highlights.' : '#Class1#=.cl99{background-color: #ff0000;} ',
	'Class Example 4: Add box chadow to element when activated. Called with [div class=cl99]My Value[/div] in highlights.' : '#Class1#=.cl99{box-shadow: 0px 0px 10px 10px #E8DD95;} ',
	'Class Example 5: Move element back and forth continuously when activated. Called with [div class=cl99]█[/div] in highlights.' : '#Class1#=.cl99{animation: myAnim 1s linear 0s infinite alternate-reverse;} @keyframes myAnim {0% {transform: translateX(-20px);}100% {transform: translateX(20px);} }',
	'Class Example 6: Spin an element continuously when activated. Called with [div class=cl99]❌[/div] in highlights.' : '#Class1#=.cl99{animation: myAnim 1s linear 0s infinite normal forwards;} @keyframes myAnim {0% {transform: rotate(0deg);}100% {transform: rotate(360deg);} }',	
	'Class Example 7: Call off-loaded Animation Class: Call an animation class YOU defined in the Dashboard CSS file as .spin{animation: spin 1s linear 0s 2 normal forwards;} @keyframes spin {0% {transform: rotate(0deg);}100% {transform: rotate(360deg);}}' : '#Row#=animation: spin 1s linear 0s 2 normal forwards;',
	'Class Example 8: Define two classes at once, .on and .off. Called with [div class=on]💡[/div] or [div class=off]💡[/div] in highlights.' :  '#Class1#=.off{opacity:0.5} .on{text-shadow: 0px 0px 15px #ffff00;}' 
    ]
}

def getOverrideTextList(){
    return [
    'Text - Alignment: Sets the alignment of text.' : '#Header#=text-align: left;',
	'Text - Bold: Sets text to a font-weight equivalent of bold.' : '#Data#=font-weight:700',
	'Text - Decoration: Sets decorative elements for text such as underlining.' : '#Header#=text-decoration: underline wavy #C34E4E;',
	'Text - Letter Spacing: Change the letter spacing of text.' : '#Data#=letter-spacing:5px',
	'Text - Shadow: Sets a diffuse shadow effect of one or more specified colors around text.' : '#Data#=text-shadow: 5px 5px 10px #F33E25, 0px 0px 16px #EAA838;',
    'Text - Transform: Sets the afffected text to Capitalized, Lower Case or Upper Case.' : 'text-transform: uppercase;',
	'Text - Word Spacing: Sets the spacing between words in pixels.' : '#Data#=word-spacing: 20px;' 
    ]
}

def getOverrideMarginPaddingList(){
    return [
    'Margin: Adds a margin to an element to increase space between elements for visual appeal. Margin can be a negative number. See also padding.' : "#Title#=margin-top:10px; margin-bottom:5px; margin-left:-50px | #Footer#=margin-top:5px",    
	'Padding: Show a border around all primary elements to help diagnose\\understand margin & padding issues.' : '#Title#=outline: 2px dotted red | #Table#=outline: 2px dotted yellow | #Footer#=outline: 2px dotted blue | #Box#=outline: 2px dotted green | #Alternaterow#=outline: 2px dashed purple;',
    'Padding: Adds a minimum amount of space between or within an object. If you have Borders enabled use border padding to control row height. If not, use text padding. Example uses both.' : '#Border#=padding:5px; | #Title#=padding-bottom:10px; | #Data#=padding:5px;' 
    ]
}

def getOverrideMiscList(){
    return [
    'Box Shadow: Sets a diffuse color box around the edge of an object.' : '#Table#=box-shadow: 0px 0px 10px 10px #E8DD95;',
    'Color: Sets the color of an object.' : '#Header#=color: #5049EA;',
    'Hover: Sets the mouse cursor shape when hovering over an object. Applies to all tiles on a dashboard.' : '#Row#=cursor: se-resize;',
    'Hover: Changes the text color and size of data [td] cells when it is hovered over. Applies to all tiles on a dashboard.' : '#Class1#=td:hover {color:green;transform:scale(1.2)}',
    'Hover: Sets a linear repeating gradient on an object when it is hovered over. Applies to all tiles on a dashboard.' : '#Class1#=td:hover{background-image: repeating-linear-gradient(45deg, red 0px, red 10px, red 10px, yellow 10px, yellow 20px)!important;opacity:0.5}',
    'Hover: Puts a yellow border around an object whe it is hovered over. Applies to all tiles on a dashboard:' : '#Class1#=td:hover {outline: 10px solid #ffff00} | #Table#={outline: 10px solid #ffff00;outline: 1px solid #C34545; transition: outline 1s ease 0s;}',
    'Macros: Show the available macro terms that can be expanded. <b>Enable Title First!</b>' : "#ts#=80% | #ta#=Left | #tt#=Day = %day% (abbreviated day)[br]Time = %time% (abbreviated time) [br] Units = '%units%' (Selected units, if any)[br] Count = %count% (Results in table)",
    'Opacity: Sets the opacity of an object in the range 0 (transparent) to 1 (opaque).' : '#Header#=opacity: 0.5;',
    'Outline: Draws an outline around the OUTSIDE of an object.' : '#Table#=outline: 2px solid red;'   
    ]     
}

def getOverrideTransformList(){
    return [
    'Rotate in 2D: Rotates an object in 2 dimensions.' : '#Table#=transform: rotate(3deg) | #Title#=transform: rotate(-3deg); | #ts#=160;',
    'Rotate in 3D: Rotates an object in 3 dimensions.' : '#Header#=transform: rotateX(20deg) rotateY(15deg) rotateZ(5deg);',
    'Scale: Changes the scale of an object to make it smaller or larger.' : '#Table#=transform: scale(0.9);',
    'Skew: Skews an object to give it a 3D look.' : '#Data#=transform: skew(24deg, 2deg) | #Header#=transform: skew(-24deg, -2deg);',
    'Perspective: Changes the perspective of the affected object.' : '#Row#=Perspective: 150px; transform: rotateX(25deg) rotateY(20deg);transform-style: preserve-3d;',
    'Translate: Moves an object up, down, left or right.' : '#Row#=transform: translate(20px, -10px) | #Title#=transform: translate(0px, 300px);'
    ]     
}


//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Child Functions Notes - These are the on-screen help text during the design process.
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************



def filterNotes() {
    myText = 'You can filter a result set to match only those items matching\\not matching certain criteria. For example you may only want to see open doors, temperatures above 80°F or lights that are on.<br>'
    myText += '<b>Filtering has several advantages:</b><br>'
	myText += '<b>1)</b> It produces a smaller result set so tile can be smaller on the dashboard.<br>' 
	myText += '<b>2)</b> The tile will be smaller in bytes, leaving more room for embellishment if desired.<br>'
	myText += '<b>3)</b> A table with filtered results can really focus a dshboard on what is truly important and alleviate the need to scan a dashboard looking for out of compliance conditions.<br>'
	myText += '<b>Filtering of floating point numbers occurs based on the database value</b>, not the rounded value shown in the table based upon your decimal point preference.<br>'
	myText += 'Filter settings with a mismatch between a text\\numeric filter type and an appropriate datatype will be ignored.<br>'
	myText += 'Filtering is only available in <b>Tile Builder Advanced</b>.'
    return myText
}

def generalNotes() {
    myText = 'Generally you should leave the table width and height at the default values (W=100%, H=Auto) and change the border padding (if border is enabled) or change the row text and header text padding if the border is not enabled.<br>'
    myText += '<b>Base Font Size</b> is the reference point for all other text sizes which use % values. Changing this value allows you to match the tile preview with the published Dashboard version and make the design process more accurate. '
    myText += "The default value of 18px provides a visual match for the Dashboard default 'Font Size' of 12 unknown units.<br>"
    myText += '<b>Font Family</b> allows you to choose an alternate font, but you must check whether your Dashboard devices can render the font you specify. The default font is <b>Roboto. </b>'
    myText += 'You can use overrides to specify an alternate font not included in the menu system, for example: <b>#tff#:Helvetica or #tff#:Blackadder ITC</b> are examples of overrides to specify an alternate device font.<br>'
    myText +=  'A <b>frame adds about 65 bytes</b> plus any other settings that may be added via overrides. Frame padding is set to 20px. With the Advanced version you can override this with #Frame#=padding:20px;.'
    myText += 'If your frame shows as top and bottom stripes it means you have a background color applied to the table, but a table width of 100%. Reduce the table width for proper border appearance.</br>'
    myText += '<b>Use Custom Preview Size:</b> If you use a Hubitat dashboard tile size other than the default of 200 x 190 you can match that by enabling this setting and entering your planned tile size. Preview is still an approximation dependant on Hubitat dashboard padding.<br>'
    myText +=  'A <b>comment adds 11 bytes</b> plus the comment text. Comments are saved within the HTML but are not visible.<br>'
    return myText
}

def titleNotes() {
    myText = 'You can add HTML tags to text fields using square brackets such as [b][u]My Header[/u][/b].<br>'
    myText += "You can use %day%, %time%, %units% or %count% in any text field. They will be replaced by current day, current time, selected units (when applicable) or number of data lines in the table. Using %count% is especially useful if you employ scrolling tables on a dashboard. "
    myText += "Using '[b]My Title[/b][br][font size=2]%day% %time%[/font]' spreads the title and time across two lines and provides a more attractive display. "
    myText += "This option let's you avoid the overhead of a footer when space is tight. You can use the same technique in the footer or header fields.<br>"
	myText += "You can use <b>Hyperlinks</b> in the texct fields using the form: [a href='http://192.168.0.200']My Title[/a].<br>"
    myText += 'Enabling <b>a title adds 112 bytes</b> to the HTML size plus the title text. Enabling <b>a title shadow adds 35 bytes</b> to the HTML size.<br>'
    myText += 'When space is tight you can disable the Title and use a merged header field instead.'
    return myText
}

def headerNotes() {
    myText = 'Header padding settings are ignored whenever a Border is enabled and Border padding is > 0.<br>'
    myText += 'You can add HTML tags to text fields using square brackets such as [b][u]My Header[/u][/b].<br>'
	myText += "You can use <b>Hyperlinks</b> in the Header fields using the form: [a href='http://192.168.0.200']My Header[/a]. <br>"
    myText += 'Enabling column <b>headers adds about 45 bytes</b> plus the header text.<br>'
    myText += '<b>Merge Headers</b> provides an alternate way of adding a title to a table and is very space efficient.'
    return myText
}

def borderNotes() {
    myText = 'Header and Row padding settings are ignored whenever a Border is enabled and Border padding is > 0.<br>'
    myText += "Using a setting of 'Border Mode' = 'Seperate' on the General Tab can give the appearance of a border but consumes less space as borders can be turned off. The perceived 'border' color is actually the table background color.<br>"
    myText += 'Border Radius applies to each individual cell, not the table as a whole. A <b>border adds about 85 bytes</b>.<br>'
    return myText
}

def rowNotes() {
    myText = 'Row padding settings are ignored whenever a Border is enabled and Border padding is > 0.<br>'
    myText += '<b>The default opacity for the row background color is 0.</b> This effectively makes the Table background (General tab) the default row color. In this configuration, enabling Alternate Row colors visually works as you would expect. '
	myText += 'Changing the Row Opacity to a non zero value alters the colors but not in an intuitive way. Using these settings with Border Mode Seperate creates a border effect, without borders being enabled and saves significant space when employed.<br>'
	myText += 'Enabling <b>alternate rows adds about 70 bytes</b>.'
    return myText
}

def footerNotes() {
    myText = 'You can add HTML tags to text fields using square brackets such as [b][u]My FooterH[/u][/b].<br>'
    myText += "You can use %day%, %time%, %units% or %count% in any text field. They will be replaced by current day, current time, selected units (when applicable) or number of data lines in the table. "
    myText += 'Enabling <b>a footer adds about 95 bytes</b> plus the footer text.'
    return myText
}

def highlightNotes() {
    myText = "<b>Keywords:</b> These are used to match a string value and can be enhanced with color, size or completely replaced. For example, rather than display the word 'closed', a ✔️ mark could be displayed instead or "
    myText += "the phrase 'not present' could be replaced with 'Away' or 'Out' if preferred. You can use HTML tags as part of the replacement string, for example replace 'closed' with '[b]OK[/b]' will make the result show as bolded.<br>"
    myText += "<b>Thresholds:</b> These allow numeric values that meet >=, ==, or <= conditions to be highlighted. These use the same highlight controls as Keywords and have the same impact on HTML size. You can use replacement values for numeric data. "
    myText += "On a battery monitoring tile you could change the display for all batteries <= 50 to 'Replace' and highlight it in red.<br>"
	myText += "You can animate a result by using something like this: '[div class=cl99]❌[/div]' as the replacement text. The class must be defined in the Advanced Tab - Overrides field or in the dashboard CSS. See Overrides Helper for examples.<br>"
    myText += "Each active <b>highlight style adds 35 bytes plus 11 bytes per affected row</b> to the HTML size. This may be partially offset by replacing longer phrases like 'not present' with 'Away'. <br>"
    myText += "<b>Note:</b> By applying a highlight color that matches the background color you can make certain values invisible, effectively making it a lowlight."
    return myText
}

def styleNotes() {
    myText = 'Styles are a collection of settings for quickly and consistently modifying how data is displayed. Here you can apply built-in styles, create new styles or retrieve styles that you have created previously and apply them to the current table. '
    myText += 'Styles are stored in the parent app so a style created here will be available in other field compatible child apps. The same holds true of deletions.<br>'
    myText += "<b>Style Names:</b> Style names are <u>automatically</u> pre-fixed with 'Style-AM '. A style with a leading * is a built-in style that will always sort to the top of the list. You can delete Built-In styles but they will be restored if the <b>Tile Builder</b> parent app is re-installed.<br>"
    myText += "<b>Important:</b> When saving a new style <b>you must hit enter or tab</b> to leave the 'Save as Style' field and save that value. Then you can click the 'Save Current Style' button.<br>"
    myText += '<b>Import\\Export</b> allows you to easily share styles that you create with other Hubitat users by simply cutting and pasting the displayed strings to\\from Hubitat community forums.'
    return myText
}

def advancedNotes() {
    myText = '<b>Scrubbing:</b> Removes unneccessary content and shrinks the final HTML size by about 20%. Leave on unless your Tile Preview does not render correctly.<br>'
    myText += "<b>Enable Overrides:</b> Turns on\\off the processing of the contents of the '<u>Settings Overrides</u>' field. Using overrides you can achieve many styles and effects not available through the 'Customize Table' interface.<br>"
    myText += '<b>Show Effective settings:</b> Displays the merged result of the basic settings with the overrides applied. It is primarily a diagnostic tool and will normally be left off.<br>'
    myText += "<b>Show Pseudo HTML:</b> Displays the HTML generated with any '<' or '>' tags replaced with '[' and ']'. This can be helpful in visualizing the HTML for the purposes of optimization. Normally this will be turned off.<br>"
    return myText
}

def overrideNotes() {
    myText = "<b>Overrides</b> allow any value to be overridden using the field code and the replacement value. Field replacement overrides are entered in the form #fc1#=XX1 | #fc2#=XX1 etc. for field replacements where 'fc?' is the field code and 'XX?' is the value. "
    myText += 'Field codes are an abbreviated version of the field name, for example #tt# is the title text, #fc# is the footer color, #rta# is the row text alignment and "| is the seperator between multiple entries. <b>You can find a full list of the field codes in Appendix A of the documentation at link below.</b> '
    myText += 'Enable the Title and try this --> <mark>#ta#=Left | #tc#=#00FF00 | #ts#=80</mark> <-- '
    myText += "The Title text should move to the left and change it's color and size.<br>"
    myText += '<b>Why use field codes?</b> Basically they allow you to get outcomes not achievable via the GUI controls. For example using <mark>#tff#=Arial Rounded MT</mark> allows the user to specify a font that is not an option in the menu system.'
    myText += 'This approach also allows you to take an existing style, modify it in a few small ways without creating a whole new style. Using overrides keeps the variances from the base style obvious.<br>'
    myText += "<b>Style Enhancements:</b> These are very powerful enhancements that allow the user to extend the properties of different elements such as 'Table', 'Border', 'Title' to add capabilities such as adding animations, shadows, gradients and transformations. "
    myText += "You can see examples of these in the <b>'Overrides Helper'</b>. A full discussion of the properties can be found in the documentation at link below.<br>"
    myText += "<b>Show Overrides Helper:</b> Overrides are very powerful, but not intuitive. To reduce the learning curve the <b>Overrides Helper</b> provides 40+ examples to perform a variety of operations on different components of the table."
    myText += "The best thing to do is just try them out. Simply pick a <u>Sample Override</u> to try out, click the <b>Copy to Overrides</b> and then click <b>Refresh Table</b> to apply them. Most efects will be visible right away, some might only be visible during a browser refresh."
    myText += 'In some cases an effect may not be visible at all. For example setting the table background to a gradient will only be visible if the table rows and\\or the table header have an opacity less than 1.<br>'
	myText += '<b>#Class1#</b> names are: #Table#, #Title#, #Header#, #Row#, #Data#, #Footer# and #Border#. See documentation for others.<br>'
    myText += "See the full <b>Tile Builder</b> documentation at this <a href='https://github.com/GaryMilne/Documentation/blob/main/Tile%20Builder%20Help.pdf'>link.</a> There are multiple web resources for building these CSS strings but here is an easy one to get you started: https://webcode.tools/generators/css"
    return myText
}

def displayTips() {
    myText =  'This is a <b>close approximation</b> of how the table will display within a dashboard tile. Once the table is published to a tile you can quickly make changes and publish them to see exactly how they look. '
    myText += "If the Hubitat Dashboard says, 'Please Configure an Attribute' then make sure an attribute is selected and then reload the dashboard to correct it.<br>"
    myText += '<b>Adjusting Height and Width:</b> The final dimensions of the table are affected by many factors, especially the height. The number of rows of data, border size, border padding, text size, base font size, font face, frame, title, title padding etc all impact the height. '
    myText += 'To start with adjust the Border padding OR Row padding, then the text sizes and finally the table height and width.<br>'
    myText += '<b>Hubitat Dashboard:</b> Because <b>Tile Builder</b> tiles hold data from multiple devices you will likely use 1x2 or 2x2 tiles vs the default 1x1 Hubitat Dashboard. The tile background color and opacity shown here are for visualization only. The Hubitat Dashboard settings '
    myText += "will determine these settings when the tiles are published. To make the tile background transparent you can add a line like this to your Hubitat Dashboard CSS <b><i>'#tile-XX {background-color: rgba(128,128,128,0.0) !important;}'</i></b> where XX is your <b>Hubitat Dashboard tile number.</b> "
    myText += ' (This is not the same as the Tile Builder tile number you assigned during publishing.)<br>'
    myText += '<b>Dashboard Background:</b> You can use the dropper tool within the Dashboard Color dialog to get an exact match for your dashboard background to make selecting your color palette easier. Once placed on a dashboard the <b>tiles will automatically be centered vertically</b>.<br>'
    myText += '<b>Use Custom Preview Size:</b> If you use a Hubitat dashboard tile size other than the default of 200 x 190 you can match that by enabling this setting and entering your preferred grid size. Preview is still an approximation dependant on Hubitat dashboard padding.'
    return myText
}



//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//**************
//**************  Installation and Update Functions
//**************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************************************************************

def installed() {
    if (isLogTrace) log.trace ('installed: Entering installed')
    if (isLogInfo) log.info "Installed with settings: ${settings}"
}

def updated() {
    if (isLogTrace) log.trace ('updated: Entering updated')
    if (isLogInfo) log.info "Updated with settings: ${settings}"
    unschedule()
    unsubscribe()
}

def initialize() {
    if (isLogTrace) log.trace ('initialized: Entering initialize')
    if (isLogInfo) log.info ('Running Initialize.')
    if ( state.initialized == true ) {
        if (isLogInfo) log.info ('initialize has already been run. Exiting')
        return
    }
    makeDefaultStyles()

    //Set the flag so that this should only ever run once.
    state.initialized = true

    //Set initial Log settings
    app.updateSetting('isLogDebug', false)
    app.updateSetting('isLogTrace', false)
    app.updateSetting('isLogInfo', false)
    app.updateSetting('isLogWarn', true)
    app.updateSetting('isLogError', true)

    state.setupState = 0
    state.showIntro = true
    state.showLicense = false
    state.showDevice = false
    state.showCreateEdit = false
    state.showManage = false
    state.showMore = false
    state.descTextEnable = false
    state.debugOutput = false
    state.isStorageConnected = false
    state.flags = [selectedDeviceChanged: false]
    state.selectedDeviceHistory = [new: 'seed1', old: 'seed']
    state.isAdvancedLicense = false
    state.activationState = "Not Activated"
    
    app.updateSetting("myInput", [value:"#c61010", type:"color"])
    app.updateSetting('selectedDevice', 'Tile Builder Storage Device 1')
}


//Determine if something has changed in the command list.
def isSelectedDeviceChanged() {
    if (state.selectedDeviceHistory.new != selectedDevice) {
        state.selectedDeviceHistory.old = state.selectedDeviceHistory.new
        state.selectedDeviceHistory.new = selectedDevice
        state.flags.selectedDeviceChanged = true
    }
    else { state.flags.selectedDeviceChanged = false }
}
