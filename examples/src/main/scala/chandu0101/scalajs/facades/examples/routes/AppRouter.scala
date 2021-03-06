package chandu0101.scalajs.facades.examples.routes


import chandu0101.scalajs.facades.examples.pages.components.leaflet._
import chandu0101.scalajs.facades.examples.pages.components.pouchdb._
import chandu0101.scalajs.facades.examples.pages.{HomePage, LeafLetPage, PouchDBPage}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, RoutingRules}
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom


/**
 * Created by chandrasekharkode .
 */
object AppRouter {

  object AppPage extends RoutingRules {

    val root = register(rootLocation(HomePage()))

    // pouchdb
    val pcreateDB: Loc = register(location("#pouchdb/createdb", PouchDBPage(PCreateDB())))
    val pdeleteDB: Loc = register(location("#pouchdb/deletedb", PouchDBPage(PDeleteDB())))
    val pcreateupdateDoc: Loc = register(location("#pouchdb/createupdatedoc", PouchDBPage(PCreateUpdateDoc())))
    val pgetDoc: Loc = register(location("#pouchdb/getdoc", PouchDBPage(PGetDoc())))
    val pdeleteDoc: Loc = register(location("#pouchdb/deletedoc", PouchDBPage(PDeleteDoc())))
    val pCreateUpdateBulkDocs: Loc = register(location("#pouchdb/createupdatebulkdocs", PouchDBPage(PCreateUpdateBulkDocs())))
    val pAllDocs: Loc = register(location("#pouchdb/alldocs", PouchDBPage(PAllDocs())))
    val pChanges: Loc = register(location("#pouchdb/changes", PouchDBPage(PChanges())))
    val pReplicate: Loc = register(location("#pouchdb/replicate", PouchDBPage(PReplicate())))
    val pSync: Loc = register(location("#pouchdb/sync", PouchDBPage(PSync())))
    val pInfo: Loc = register(location("#pouchdb/info", PouchDBPage(PInfo())))
    val pCompact: Loc = register(location("#pouchdb/compact", PouchDBPage(PCompact())))
    val pDebug: Loc = register(location("#pouchdb/debug", PouchDBPage(PDebug())))


    //leaflet

    val linfo: Loc = register(location("#linfo", LeafLetPage(LInfo())))
    val lBasicMap: Loc = register(location("#lbasicmap", LeafLetPage(LBasicMap())))
    val lMarker: Loc = register(location("#lmarker", LeafLetPage(LMarkerDemo())))
    val lPopup: Loc = register(location("#lpopup", LeafLetPage(LPopupDemo())))
    val lMarkerOptions: Loc = register(location("#lmarkeroptions", LeafLetPage(LMarkerOptionsDemo())))
    val lMarkers: Loc = register(location("#lmarkers", LeafLetPage(LMarkersDemo())))
    val lPolyline: Loc = register(location("#lpolyline", LeafLetPage(LPolylineDemo())))
    val lCircle: Loc = register(location("#lcircle", LeafLetPage(LCircleDemo())))
    val lCustomMarkers: Loc = register(location("#lcustommarkers", LeafLetPage(LCustomMarkersDemo())))
    val lGeoJson: Loc = register(location("#lgeojson", LeafLetPage(LGeoJSONDemo())))
    val lGeoJsonStyle: Loc = register(location("#lgeojsonstyle", LeafLetPage(LGeoJSONStyle())))
    val lGeoJsonPointToLayer: Loc = register(location("#lpointtolayer", LeafLetPage(LGeoJSONPointToLayer())))
    val lGeoJsonOnEachFeature: Loc = register(location("#loneachfeature", LeafLetPage(LGeoJSONonEachFeature())))
    val lInteractiveMap: Loc = register(location("#linteractive", LeafLetPage(LInteractiveMap())))
    val lOfflineTiles: Loc = register(location("#lofflinetiles", LeafLetPage(LOfflineTiles())))
    val lEvents: Loc = register(location("#levents", LeafLetPage(LEventsDemo())))


    register(removeTrailingSlashes)

    override protected val notFound = redirect(root, Redirect.Replace)

    def currentRoute = dom.window.location.href.substring(baseUrl.value.length)

    override protected def interceptRender(i: InterceptionR): ReactElement =
      div(background := "rgb(52, 57, 60)", minHeight := "800px",
        i.element
      )


    def getTitle(loc: String) = {
      if (loc.contains("materialui")) "Material-UI"
      else if (loc.contains("reacttable")) "React Table"
      else ""
    }

  }


  val baseUrl = BaseUrl.fromWindowOrigin / "scalajs-facades/examples/"
//    val baseUrl = BaseUrl.fromWindowOrigin / "sjsf/"

  val C = AppPage.router(baseUrl)
}
