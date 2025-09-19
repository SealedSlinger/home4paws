import Header from "./components/Header/Header";
import ReportInjuredDogs from "./pages/ReportInjuredDogs/ReportInjuredDogs";
import Nav from "./components/Header/nav";

function App() {
  return (
    <div>
      <Header />
      <Nav activePage="report" />
      <ReportInjuredDogs />
    </div>
  );
}

export default App;