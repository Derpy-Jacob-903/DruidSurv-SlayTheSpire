package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;

import static druidsurv.ModFile.makeID;

public class RainbowBloon extends AbstractEasyCard {
    public final static String ID = makeID("RainbowBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public RainbowBloon() {
        super(ID, 3, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.SELF_AND_ENEMY, "RainbowBloon_CardArt");
        baseDamage = 72;
        //baseBlock = 3;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 3, damage, "Rainbow Bloon"), 1, true, AbstractGameAction.AttackEffect.NONE));
        //bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(15);
        upgradeBlock(3);
    }
}