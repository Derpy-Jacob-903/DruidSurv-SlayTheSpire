package druidsurv.cards.strikerjones;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class StrikerBasicMonkey extends AbstractEasyCard {
    public final static String ID = makeID("StrikerStrikeMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public StrikerBasicMonkey() {
        super(ID, 1, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY,  CharacterFile.Enums.STRIKER_COLOR, "Strike");
        baseDamage = 6;
        tags.add(CardTags.STRIKE);
        tags.add(CardTags.STARTER_STRIKE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}