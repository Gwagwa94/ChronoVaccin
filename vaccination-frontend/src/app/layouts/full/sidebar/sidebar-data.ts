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
    displayName: 'Actualités',
    iconName: 'rosette',
    route: '/ui-components/badge',
  },
  {
    displayName: 'Centre',
    iconName: 'poker-chip',
    route: '/ui-components/chips',
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
];
