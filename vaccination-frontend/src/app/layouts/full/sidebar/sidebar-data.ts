import { NavItem } from './nav-item/nav-item';

export const navItems: NavItem[] = [
  {
    navCap: 'Général',
  },
  {
    displayName: 'Accueil',
    iconName: 'layout-dashboard',
    route: '/dashboard',
  },
  {
    navCap: 'Recherche',
  },
  {
    displayName: 'Mon Espace',
    iconName: 'rosette',
    route: '/ui-components/badge',
  },
  {
    displayName: 'Centre',
    iconName: 'poker-chip',
    route: '/ui-components/chips',
  },
  {
    displayName: 'Lists',
    iconName: 'list',
    route: '/ui-components/lists',
  },
  {
    displayName: 'Menu',
    iconName: 'layout-navbar-expand',
    route: '/ui-components/menu',
  },
  {
    displayName: 'Tooltips',
    iconName: 'tooltip',
    route: '/ui-components/tooltips',
  },
  {
    navCap: 'Profil',
  },
  {
    displayName: 'Connexion',
    iconName: 'lock',
    route: '/authentication/login',
  },
  {
    displayName: 'Inscription',
    iconName: 'user-plus',
    route: '/authentication/register',
  },
  {
    navCap: 'Extra',
  },
  {
    displayName: 'Icons',
    iconName: 'mood-smile',
    route: '/extra/icons',
  },
  {
    displayName: 'Sample Page',
    iconName: 'aperture',
    route: '/extra/sample-page',
  },
];
